package com.study.graphql.tutorial.repository;

import com.study.graphql.tutorial.domain.Manufacture;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@Repository
public class ManufactureRepository {

    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ManufactureRepository(final DataSource dataSource) {
        super();
        this.dataSource = dataSource;
        this.jdbcTemplate =  new JdbcTemplate(dataSource);
    }

    @PostConstruct
    private void initialize() {
        insertManufacturers(getManufacturers());
    }

    public void insertManufacturers(final List<Manufacture> manufacturers) {
        String sql = "INSERT INTO MANUFACTURE " + "(id, name, address) VALUES (?, ?, ?)";
        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Manufacture manufacture = manufacturers.get(i);
                ps.setString(1, manufacture.getId());
                ps.setString(2, manufacture.getName());
                ps.setString(3, manufacture.getAddress());
            }
            @Override
            public int getBatchSize() {
                return manufacturers.size();
            }
        });
    }

    public List<Manufacture> getManufacturers(){
        Manufacture[] manufs = new Manufacture[] {
                Manufacture.builder().id("SAMSUNG").name("Samsung").address("Seocho-daero, Seoul, Korea").build(),
                Manufacture.builder().id("APPLE").name("Apple Inc").address("Cupertino, California, USA").build(),
                Manufacture.builder().id("NOKIA").name("Nokia").address("Espoo, Finland").build()

        };

        return Arrays.asList(manufs);
    }

    public Manufacture getManufacturerById(String manufacturerID) {
        String sql = "SELECT * FROM Manufacturer WHERE id = ?";

        return jdbcTemplate.queryForObject(sql, new RowMapper<Manufacture>() {

            @Override
            public Manufacture mapRow(ResultSet rs, int rowNum) throws SQLException {
                return Manufacture.builder()
                        .id(rs.getString("id"))
                        .name(rs.getString("name"))
                        .address(rs.getString("address"))
                        .build();
            }

        }, new Object[] { manufacturerID });
    }

}
