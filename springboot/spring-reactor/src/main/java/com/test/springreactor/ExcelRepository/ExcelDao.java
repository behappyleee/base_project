package com.test.springreactor.ExcelRepository;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ExcelDao {

    @Autowired
    SqlSession sqlSession;

    private final String excelMapperName = "ExcelDownMapper";

    public int dataCount() {
        return sqlSession.selectOne(excelMapperName + ".selectTest");
    }




}
