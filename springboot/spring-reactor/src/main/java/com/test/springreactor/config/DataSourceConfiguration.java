package com.test.springreactor.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages="com.test.springreactor.**", sqlSessionFactoryRef="sqlSessionFactory")
public class DataSourceConfiguration {

    // TODO
    // Project Run 할 시 
    // Failed to instantiate [org.apache.ibatis.session.SqlSessionFactory]: Factory method 'sqlSessionFactory' threw exception with message: org/springframework/core/NestedIOException
    // 해당 ERROR 해결하여야 함

    // TODO -> 해당 mybatis Version 수정 하니 작동 하는 것 같음 더 TEST 필요 !!!

    @Autowired
    ApplicationContext applicationContext;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource") // 해당 Bean 이 생성 되면서 해당 프로퍼티에 대한 값을 가져와 사용한다.
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(@Autowired DataSource dataSource, ApplicationContext applicationContext) throws Exception{
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean(); //팩토리 빈 생성
        factoryBean.setDataSource(dataSource); //미리 만들어 놓은 DataSource 빈을 주입하여 넣어준다.
        factoryBean.setMapperLocations(applicationContext.getResources("classpath:mapper/*.xml")); //쿼리 실행을 위해 만들어 놓은 해당 위치의 xml 파일을 맵퍼로 설정
        SqlSessionFactory factory = factoryBean.getObject();
        factory.getConfiguration().setMapUnderscoreToCamelCase(true);
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(@Autowired SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory); //sqlSessionTemplate 에 만들어 놓은 팩토리 주입
    }
}
