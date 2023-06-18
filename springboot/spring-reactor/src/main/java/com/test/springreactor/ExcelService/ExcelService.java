package com.test.springreactor.ExcelService;

import com.test.springreactor.ExcelRepository.ExcelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class ExcelService {

    @Autowired
    ExcelDao excelDao;

    public void getTestData(ModelAndView mv) {



        // mv.addObject("testData", excelDao.excelTestData());
    }

}
