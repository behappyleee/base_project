package com.test.springreactor;

import com.test.springreactor.ExcelRepository.ExcelDao;
import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class ExcelDownloadTest {

    Logger logger = LoggerFactory.getLogger(ExcelDownloadTest.class);

//    @Autowired
//    ExcelDao excelDao;

    @Test
    public void excelDownloadTest() {
        System.out.println("EXCEL DOWNLOAD TEST CHECK !!");
        HashMap<String, Object> dataCheck = testDBConnect();

        logger.debug("SELECT RESULT : {} " , dataCheck);

        // File file = new File("");
    }

    // public List<HashMap<String, Object>> getAllData () {
    public HashMap<String, Object> testDBConnect () {
        ExcelDao dao = new ExcelDao();
        dao.excelTestData();
        return dao.excelTestData();
    }

}
