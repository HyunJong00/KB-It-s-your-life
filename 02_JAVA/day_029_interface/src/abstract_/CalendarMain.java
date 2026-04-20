package day_029_interface.src.abstract_;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarMain {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println("오늘 날짜: "+ date);

        SimpleDateFormat sdf = new SimpleDateFormat("y년 MM월 hh시");
        System.out.println(sdf.format(date));

        // 추상 클래스로 new 불가
        // Calendar cal = new Calendar();
        // Calendar cal = new GregorianCalendar();
        Calendar cal = Calendar.getInstance(); // 싱글톤 아님, 팩토리 패턴임

        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);

        System.out.println(year+ "년 "+month+"월 "+day+"일 "+hour+"시 "+minute+"분 "+second+"초");

    }

}

