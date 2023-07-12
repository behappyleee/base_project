package com.test.springwebflux.excel.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class ExcelDao {

    @Autowired
    SqlSession sqlSession;

    private final String testMapper = "TestMapper";

    public List<HashMap<String, Object>> selectAllData() {
        return sqlSession.selectList(testMapper + ".selectAllData");
    }


    public HashMap<String, Object> excelTestData() {
        return sqlSession.selectOne(testMapper + ".selectTestDataCheck");
    }

}
