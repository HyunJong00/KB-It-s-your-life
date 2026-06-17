package org.scoula.travel.service;

import org.scoula.travel.dao.TravelDao;
import org.scoula.travel.domain.Travel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 여행지 관련 비즈니스 로직을 처리하는 서비스 클래스입니다.
 */
public class TravelService {
    private final TravelDao dao = TravelDao.getInstance();
    private final Scanner scanner = new Scanner(System.in);

    /**
     * 1. 전체 목록 출력 메서드
     * 권역(District) 순, 제목(Title) 순으로 정렬하여 출력합니다.
     */
    public void printAllList() {
        // 원본 데이터 보호를 위해 복사본 생성 후 정렬
        List<Travel> list = new ArrayList<>(dao.findAll());
        list.sort(Comparator.comparing(Travel::getDistrict)
                           .thenComparing(Travel::getTitle));
        
        System.out.println("\n[전체 여행지 목록 (정렬: 권역 > 제목)]");
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-4s | %-6s | %-20s | %-40s\n", "번호", "권역", "여행지명", "주소");
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        
        for (Travel t : list) {
            System.out.printf("%-4d | %-6s | %-20s | %-40s\n", 
                t.getNo(), t.getDistrict(), t.getTitle(), t.getAddress());
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.printf("총 %d개의 여행지가 있습니다.\n", list.size());
    }

    /**
     * 2. 페이지별 목록 출력 메서드
     * 정렬된 목록을 10개씩 끊어서 페이지 단위로 출력합니다.
     */
    public void printPageList() {
        // 원본 데이터 복사 및 정렬
        List<Travel> list = new ArrayList<>(dao.findAll());
        list.sort(Comparator.comparing(Travel::getDistrict)
                           .thenComparing(Travel::getTitle));

        int pageSize = 10;
        int totalItems = list.size();
        int totalPages = (int) Math.ceil((double) totalItems / pageSize);
        int currentPage = 1;

        while (true) {
            // 현재 페이지 데이터 추출
            int fromIndex = (currentPage - 1) * pageSize;
            int toIndex = Math.min(fromIndex + pageSize, totalItems);
            List<Travel> pageItems = list.subList(fromIndex, toIndex);

            System.out.printf("\n[페이지별 여행지 목록 (정렬: 권역 > 제목)] - 현재: %d / 전체: %d\n", currentPage, totalPages);
            System.out.println("----------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-4s | %-6s | %-20s | %-40s\n", "번호", "권역", "여행지명", "주소");
            System.out.println("----------------------------------------------------------------------------------------------------------------");

            for (Travel t : pageItems) {
                System.out.printf("%-4d | %-6s | %-20s | %-40s\n", 
                    t.getNo(), t.getDistrict(), t.getTitle(), t.getAddress());
            }
            System.out.println("----------------------------------------------------------------------------------------------------------------");

            System.out.print("보고자 하는 페이지 번호를 입력하세요 (엔터: 메인 메뉴로): ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                break; // 엔터 입력 시 루프 종료
            }

            try {
                int page = Integer.parseInt(input);
                if (page >= 1 && page <= totalPages) {
                    currentPage = page;
                } else {
                    System.out.printf("잘못된 페이지 번호입니다. (1 ~ %d 사이 입력)\n", totalPages);
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력 가능합니다.");
            }
        }
    }

    /**
     * 3. 권역별 목록 출력 메서드
     * 권역 목록을 먼저 보여주고, 선택한 권역의 여행지를 제목 순으로 정렬하여 출력합니다.
     */
    public void printDistrictList() {
        // 1. 고유 권역 목록 추출 및 정렬
        List<String> districts = dao.findAll().stream()
                .map(Travel::getDistrict)
                .distinct()
                .sorted()
                .toList();

        System.out.println("\n[권역 목록]");
        for (int i = 0; i < districts.size(); i++) {
            System.out.printf("%d. %s  ", i + 1, districts.get(i));
            if ((i + 1) % 5 == 0) System.out.println(); // 5개씩 줄바꿈
        }
        System.out.println("\n----------------------------------------------------------------------------------------------------------------");

        System.out.print("조회할 권역 번호를 선택하세요: ");
        String input = scanner.nextLine().trim();

        try {
            int index = Integer.parseInt(input) - 1;
            if (index >= 0 && index < districts.size()) {
                String selectedDistrict = districts.get(index);
                
                // 2. 해당 권역 데이터 필터링 및 제목순 정렬
                List<Travel> filteredList = new ArrayList<>(dao.findByDistrict(selectedDistrict));
                filteredList.sort(Comparator.comparing(Travel::getTitle));

                System.out.printf("\n[%s 권역 여행지 목록 (정렬: 제목)]\n", selectedDistrict);
                System.out.println("----------------------------------------------------------------------------------------------------------------");
                System.out.printf("%-4s | %-20s | %-40s | %-15s\n", "번호", "여행지명", "주소", "전화번호");
                System.out.println("----------------------------------------------------------------------------------------------------------------");

                for (Travel t : filteredList) {
                    System.out.printf("%-4d | %-20s | %-40s | %-15s\n", 
                        t.getNo(), t.getTitle(), t.getAddress(), t.getPhone());
                }
                System.out.println("----------------------------------------------------------------------------------------------------------------");
                System.out.printf("총 %d개의 여행지가 검색되었습니다.\n", filteredList.size());
            } else {
                System.out.println("잘못된 번호입니다.");
            }
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력 가능합니다.");
        }
    }

    /**
     * 4. 상세보기 출력 메서드
     * 여행지 번호(no)를 입력받아 해당 여행지의 상세 정보를 출력합니다.
     */
    /**
     * 4. 상세보기 출력 메서드
     * 여행지 번호(no)를 입력받아 해당 여행지의 상세 정보를 출력합니다.
     */
    public void printDetail() {
        System.out.print("상세 조회할 여행지 번호를 입력하세요: ");
        String input = scanner.nextLine().trim();

        try {
            long no = Long.parseLong(input);
            dao.findById(no).ifPresentOrElse(
                t -> {
                    System.out.println("\n[여행지 상세 정보]");
                    System.out.println("----------------------------------------------------------------------------------------------------------------");
                    System.out.printf("번호: %d\n", t.getNo());
                    System.out.printf("권역: %s\n", t.getDistrict());
                    System.out.printf("여행지명: %s\n", t.getTitle());
                    System.out.printf("주소: %s\n", t.getAddress());
                    System.out.printf("전화번호: %s\n", t.getPhone());
                    System.out.println("상세 설명:");
                    System.out.println(t.getDescription());
                    System.out.println("----------------------------------------------------------------------------------------------------------------");
                },
                () -> System.out.printf("해당 번호(%d)의 여행지 정보를 찾을 수 없습니다.\n", no)
            );
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력 가능합니다.");
        }
    }

    /**
     * 5. 키워드 검색 메서드
     * 제목 또는 설명에서 키워드를 검색하고 권역 > 제목 순으로 정렬하여 출력합니다.
     */
    public void search() {
        System.out.print("검색할 키워드를 입력하세요: ");
        String keyword = scanner.nextLine().trim();

        if (keyword.isEmpty()) {
            System.out.println("검색어를 입력해야 합니다.");
            return;
        }

        // 검색 및 정렬 (권역 > 제목 순)
        List<Travel> results = new ArrayList<>(dao.search(keyword));
        results.sort(Comparator.comparing(Travel::getDistrict)
                               .thenComparing(Travel::getTitle));

        if (results.isEmpty()) {
            System.out.printf("'%s' 키워드에 대한 검색 결과가 없습니다.\n", keyword);
        } else {
            System.out.printf("\n['%s' 검색 결과 (정렬: 권역 > 제목)]\n", keyword);
            System.out.println("----------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-4s | %-6s | %-20s | %-40s\n", "번호", "권역", "여행지명", "주소");
            System.out.println("----------------------------------------------------------------------------------------------------------------");

            for (Travel t : results) {
                System.out.printf("%-4d | %-6s | %-20s | %-40s\n", 
                    t.getNo(), t.getDistrict(), t.getTitle(), t.getAddress());
            }
            System.out.println("----------------------------------------------------------------------------------------------------------------");
            System.out.printf("총 %d개의 결과가 검색되었습니다.\n", results.size());
        }
    }
}
