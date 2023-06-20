package com.test.springreactor.excel.controller;

import com.test.springreactor.excel.service.ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class ExcelController {

    Logger logger = LoggerFactory.getLogger(ExcelController.class);

    @Autowired
    ExcelService excelService;
    
    
    // TODO 
    // HEAP SPACE ERROR 발생 시키기 !!!
    // 10000 으로는 ERROR 발생하지 않음 !!!
    // TODO logback 설정 하기 !!!
    @GetMapping("/selectAllData")
    public List<HashMap<String, Object>> selectAllData() {
        logger.debug("THIS IS SELECT ALL DATA CHECK !");
        return excelService.selectAllData();
    }

    @GetMapping("/getTestData")
    public HashMap<String, Object> getTestData(Model model) {
        logger.debug("THIS IS EXCEL CONTROLLER DATA : {} ", model);
        excelService.getTestData(model);
        return excelService.getTestData(model);
    }


}
