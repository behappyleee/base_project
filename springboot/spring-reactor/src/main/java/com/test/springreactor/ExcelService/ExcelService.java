package com.test.springreactor.ExcelService;

import com.test.springreactor.ExcelRepository.ExcelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

@Service
public class ExcelService {

    @Autowired
    ExcelDao excelDao;

    public List<HashMap<String, Object>> selectAllData() {
        return excelDao.selectAllData();
    }

    public HashMap<String, Object> getTestData(Model model) {
        // return model.addAttribute("testData", excelDao.excelTestData());
        return excelDao.excelTestData();
    }

}
