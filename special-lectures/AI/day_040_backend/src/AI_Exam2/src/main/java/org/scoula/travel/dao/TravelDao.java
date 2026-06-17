package org.scoula.travel.dao;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import org.scoula.travel.domain.Travel;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 여행지 데이터에 접근하고 관리하는 DAO 클래스입니다.
 * travel.csv 파일을 기반으로 데이터를 로드하고 CRUD 작업을 수행합니다.
 */
public class TravelDao {
    private static final String FILE_PATH = "src/main/resources/travel.csv";
    private List<Travel> travels;

    // 싱글톤 패턴 적용
    private static TravelDao instance = new TravelDao();

    public static TravelDao getInstance() {
        return instance;
    }

    private TravelDao() {
        this.travels = loadTravels();
    }

    /**
     * CSV 파일에서 여행지 목록을 불러옵니다.
     * @return 불러온 여행지 목록
     */
    private List<Travel> loadTravels() {
        try (Reader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(FILE_PATH), StandardCharsets.UTF_8))) {
            return new CsvToBeanBuilder<Travel>(reader)
                    .withType(Travel.class)
                    .build()
                    .parse();
        } catch (IOException e) {
            System.err.println("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    /**
     * 현재 메모리에 있는 여행지 목록을 CSV 파일에 저장합니다.
     */
    public void save() {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(FILE_PATH), StandardCharsets.UTF_8))) {
            StatefulBeanToCsv<Travel> beanToCsv = new StatefulBeanToCsvBuilder<Travel>(writer)
                    .withSeparator(',')
                    .withApplyQuotesToAll(true)
                    .build();
            beanToCsv.write(travels);
        } catch (Exception e) {
            System.err.println("파일을 저장하는 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    /**
     * 모든 여행지 목록을 반환합니다.
     * @return 여행지 리스트
     */
    public List<Travel> findAll() {
        return travels;
    }

    /**
     * 페이지네이션된 여행지 목록을 반환합니다.
     * @param page 현재 페이지 번호 (1부터 시작)
     * @return 해당 페이지의 여행지 리스트 (최대 10개)
     */
    public List<Travel> getPage(int page) {
        int pageSize = 10;
        int fromIndex = (page - 1) * pageSize;
        
        if (fromIndex >= travels.size()) {
            return new ArrayList<>();
        }
        
        int toIndex = Math.min(fromIndex + pageSize, travels.size());
        return travels.subList(fromIndex, toIndex);
    }

    /**
     * 전체 페이지 수를 계산합니다.
     * @return 총 페이지 수
     */
    public int getTotalPages() {
        int pageSize = 10;
        return (int) Math.ceil((double) travels.size() / pageSize);
    }

    /**
     * 주어진 번호(no)에 해당하는 여행지를 찾습니다.
     * @param no 찾을 여행지 번호
     * @return 여행지 정보를 담은 Optional
     */
    public Optional<Travel> findById(Long no) {
        return travels.stream()
                .filter(t -> t.getNo().equals(no))
                .findFirst();
    }

    /**
     * 특정 권역(district)에 해당하는 여행지 목록을 반환합니다.
     * @param district 조회할 권역 (예: 수도권, 전라권 등)
     * @return 해당 권역의 여행지 리스트
     */
    public List<Travel> findByDistrict(String district) {
        return travels.stream()
                .filter(t -> t.getDistrict().equals(district))
                .toList();
    }

    /**
     * 제목(title) 또는 설명(description)에 특정 키워드가 포함된 여행지를 검색합니다.
     * @param keyword 검색할 키워드
     * @return 키워드가 포함된 여행지 리스트
     */
    public List<Travel> search(String keyword) {
        String lowerKeyword = keyword.toLowerCase();
        return travels.stream()
                .filter(t -> t.getTitle().toLowerCase().contains(lowerKeyword) ||
                             t.getDescription().toLowerCase().contains(lowerKeyword))
                .toList();
    }

    /**
     * 새로운 여행지를 추가합니다.
     * @param travel 추가할 여행지 객체
     */
    public void create(Travel travel) {
        // 새로운 ID 할당 (현재 가장 큰 ID + 1)
        long nextNo = travels.stream()
                .mapToLong(Travel::getNo)
                .max()
                .orElse(0L) + 1;
        travel.setNo(nextNo);
        travels.add(travel);
    }

    /**
     * 기존 여행지 정보를 업데이트합니다.
     * @param travel 업데이트할 정보를 담은 여행지 객체
     */
    public void update(Travel travel) {
        for (int i = 0; i < travels.size(); i++) {
            if (travels.get(i).getNo().equals(travel.getNo())) {
                travels.set(i, travel);
                return;
            }
        }
    }

    /**
     * 주어진 번호(no)에 해당하는 여행지를 삭제합니다.
     * @param no 삭제할 여행지 번호
     */
    public void delete(Long no) {
        travels.removeIf(t -> t.getNo().equals(no));
    }
}
