package com.test.springreactor;

import com.test.springreactor.excel.dao.ExcelDao;
import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest
public class ExcelDownloadTest {

    Logger logger = LoggerFactory.getLogger(ExcelDownloadTest.class);

//    @Autowired
//    ExcelDao excelDao;

<<<<<<< HEAD
<<<<<<< HEAD
    @Autowired
    SqlSession sqlSession;

    private static final String MAPPER_NAME = "TestMapper";

    @Test
    public void excelTest() throws Exception {
        // 1. Data 읽어옴
        int selectAllTestData = selectAllTestDataCount();

        List<HashMap<String, Object>> selectAllListData = selectAllListData();

        logger.debug("SELECT ALL TEST DATA  :  {} " , selectAllTestData);
        logger.debug("SIZE CHECK 1 : {} " ,selectAllListData.size());
        logger.warn("SIZE CHECK 2 : {} " ,selectAllListData.size());

        // Apache POI 라이브러리를 사용 하여 자바 또는 웹 상에 서 Excel 다운로드 기능을 제공

//        Workbook old_workBook = new XSSFWorkbook();
//        Workbook workBook = new SXSSFWorkbook();
//        Sheet sheet = workBook.createSheet("테스트_시트");
//        // SXSSFWorkbook sw = new SXSSFWorkbook();
//        // SXSSFSheet SS = sw.createSheet();
//        int rowNum = 0;
//        String filePath = "";
//        FileOutputStream fos = new FileOutputStream(new File(filePath));
//
//        workBook.write(fos);
//        workBook.close();

    }
    
=======
>>>>>>> parent of f53596a (Excel Studying commit)
=======
>>>>>>> parent of f53596a (Excel Studying commit)
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

<<<<<<< HEAD
<<<<<<< HEAD
    public int selectAllTestDataCount() {
        return sqlSession.selectOne(MAPPER_NAME + ".selectAllTestDataCount");
    }

    public List<HashMap<String, Object>> selectAllListData() {
        return sqlSession.selectList(MAPPER_NAME + ".selectAllListData");
    }

    public HashMap<String, Object> selectOnlyOneData() {
        return sqlSession.selectOne(MAPPER_NAME + ".selectOnlyOneData");
    }



=======
>>>>>>> parent of f53596a (Excel Studying commit)
=======
>>>>>>> parent of f53596a (Excel Studying commit)
}
