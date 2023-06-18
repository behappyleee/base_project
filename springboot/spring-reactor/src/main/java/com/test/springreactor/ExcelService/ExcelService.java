package com.test.springreactor.ExcelService;

import com.test.springreactor.ExcelRepository.ExcelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExcelService {

    @Autowired
    ExcelDao excelDao;

    public void getTestData() {


    }

}
