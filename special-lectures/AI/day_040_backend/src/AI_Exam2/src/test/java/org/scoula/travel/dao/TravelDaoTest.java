package org.scoula.travel.dao;

import org.junit.jupiter.api.*;
import org.scoula.travel.domain.Travel;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TravelDaoTest {
    private TravelDao dao = TravelDao.getInstance();

    @Test
    @Order(1)
    @DisplayName("파일에서 데이터를 성공적으로 불러오는지 확인")
    void findAll() {
        List<Travel> list = dao.findAll();
        assertNotNull(list);
        assertFalse(list.isEmpty());
        System.out.println("불러온 데이터 개수: " + list.size());
    }

    @Test
    @Order(2)
    @DisplayName("특정 번호의 여행지를 조회")
    void findById() {
        Optional<Travel> travel = dao.findById(1L);
        assertTrue(travel.isPresent());
        assertEquals(1L, travel.get().getNo());
        System.out.println("조회된 여행지: " + travel.get().getTitle());
    }

    @Test
    @Order(3)
    @DisplayName("새로운 여행지 추가 테스트")
    void create() {
        int initialSize = dao.findAll().size();
        Travel newTravel = Travel.builder()
                .district("제주권")
                .title("테스트 여행지")
                .description("테스트 설명")
                .address("테스트 주소")
                .phone("010-0000-0000")
                .build();
        dao.create(newTravel);

        assertEquals(initialSize + 1, dao.findAll().size());
        assertTrue(newTravel.getNo() > 0);
        System.out.println("추가된 여행지 번호: " + newTravel.getNo());
    }

    @Test
    @Order(4)
    @DisplayName("여행지 정보 수정 테스트")
    void update() {
        Travel travel = dao.findById(1L).orElseThrow();
        String originalTitle = travel.getTitle();
        travel.setTitle("수정된 타이틀");
        dao.update(travel);

        Travel updatedTravel = dao.findById(1L).orElseThrow();
        assertEquals("수정된 타이틀", updatedTravel.getTitle());
        
        // 원복 (다른 테스트에 영향을 주지 않기 위해)
        updatedTravel.setTitle(originalTitle);
        dao.update(updatedTravel);
    }

    @Test
    @Order(5)
    @DisplayName("여행지 삭제 테스트")
    void delete() {
        // 방금 추가한 여행지 삭제 (마지막 번호)
        long lastNo = dao.findAll().stream().mapToLong(Travel::getNo).max().orElse(0L);
        int initialSize = dao.findAll().size();
        
        dao.delete(lastNo);
        assertEquals(initialSize - 1, dao.findAll().size());
        assertFalse(dao.findById(lastNo).isPresent());
    }

    @Test
    @Order(6)
    @DisplayName("페이지네이션 테스트")
    void getPage() {
        List<Travel> page1 = dao.getPage(1);
        assertEquals(10, page1.size());
        assertEquals(1L, page1.get(0).getNo());
        System.out.println("1페이지 첫 번째 항목: " + page1.get(0).getTitle());

        int totalPages = dao.getTotalPages();
        assertTrue(totalPages >= 1);
        System.out.println("전체 페이지 수: " + totalPages);
    }

    @Test
    @Order(7)
    @DisplayName("권역별 조회 테스트")
    void findByDistrict() {
        List<Travel> list = dao.findByDistrict("수도권");
        assertNotNull(list);
        assertFalse(list.isEmpty());
        assertTrue(list.stream().allMatch(t -> t.getDistrict().equals("수도권")));
        System.out.println("수도권 지역 데이터 개수: " + list.size());
    }

    @Test
    @Order(8)
    @DisplayName("키워드 검색 테스트")
    void search() {
        List<Travel> list = dao.search("인천");
        assertNotNull(list);
        assertFalse(list.isEmpty());
        assertTrue(list.stream().anyMatch(t -> t.getTitle().contains("인천") || t.getDescription().contains("인천")));
        System.out.println("'인천' 검색 결과 개수: " + list.size());
    }
}
