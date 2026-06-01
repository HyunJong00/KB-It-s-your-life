package org.scoula.travel.dataimport;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.scoula.travel.dao.JDBCUtil;
import org.scoula.travel.dao.TravelDao;
import org.scoula.travel.dao.TravelDaoImpl;
import org.scoula.travel.domain.TravelVO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class ImportTravelData {

    public static void main(String[] args) throws FileNotFoundException {
        TravelDao dao = new TravelDaoImpl();

        List<TravelVO> travels = new CsvToBeanBuilder<TravelVO>(new FileReader("travel.csv"))
                .withType(TravelVO.class)
                .build()
                .parse();

        travels.forEach(travel -> {
            System.out.println(travel);
            dao.insert(travel);
        });

        JDBCUtil.close();
    }

}
