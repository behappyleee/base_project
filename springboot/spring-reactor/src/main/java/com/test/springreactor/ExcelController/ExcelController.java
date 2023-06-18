package com.test.springreactor.ExcelController;

import com.test.springreactor.ExcelService.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExcelController {

    @Autowired
    ExcelService excelService;

    @GetMapping("/getTestData")
    public String getTestData() {
        return "THIS IS TEST DATA FROM CONTROLLER";
    }


}
