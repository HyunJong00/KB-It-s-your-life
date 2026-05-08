package org.scoula;

import org.scoula.cli.App;
import org.scoula.travel.service.TravelService;

/**
 * 애플리케이션 진입점입니다.
 * TravelService를 연동하여 메뉴를 구성하고 실행합니다.
 */
public class Main {
    public static void main(String[] args) {
        App app = new App();
        TravelService service = new TravelService();

        // 메인 메뉴 등록 (요청하신 순서대로 구성)
        app.add("전체 목록", service::printAllList);     // 1. 전체 목록
        app.add("페이지별 목록", service::printPageList); // 2. 페이지별 목록
        app.add("권역별 목록", service::printDistrictList); // 3. 권역별 목록
        app.add("상세보기", service::printDetail);      // 4. 상세보기
        app.add("검색", service::search);               // 5. 검색
        app.add("종료", app::exit);                     // 6. 종료

        // 프레임워크 실행
        app.run();
    }
}
