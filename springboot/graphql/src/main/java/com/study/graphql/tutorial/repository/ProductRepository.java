package com.study.graphql.tutorial.repository;

import com.study.graphql.tutorial.domain.Manufacture;
import com.study.graphql.tutorial.domain.Product;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

@Repository
public class ProductRepository {
    // TODO
    // Repository 및 Serice H2 Database 사용 하도록 구현 하기 !!!
    // H2 Database 설정 - In Memory 테이블, Disk 기반 둘다 생성이 가능

    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ManufactureRepository manufactureRepository;

    public ProductRepository(DataSource dataSource) {
        super();
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @PostConstruct
    private void initialize() {
        insertProducts(getProducts());
    }

    public void insertProducts(List<Product> products) {
        String sql = "INSERT INTO Product " +  "(id, title, description, rating, manufacture_id) VALUES (?, ?, ?, ?, ?)";

        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Product product = products.get(i);

                ps.setString(1, product.getId());
                ps.setString(2, product.getTitle());
                ps.setString(3, product.getDescription());
                ps.setString(4, product.getRating());
                ps.setString(5, product.getManufactureID());
            }
            @Override
            public int getBatchSize() {
                return products.size();
            }
        });
    }

    public void insertProduct(final Product product) {
        String sql = "INSERT INTO Product " + "(id, title, description, rating, manufacturer_id) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, new Object[] {product.getId(), product.getTitle(), product.getDescription(), product.getRating(), product.getMadeBy().getName()});
    }


    public List<Product> getProducts() {
        Product [] products = new Product[] {
            Product.builder().id(UUID.randomUUID().toString()).title("Samsung TV").description("Samsung Television").manufactureID("SAMSUNG").build(),
            Product.builder().id(UUID.randomUUID().toString()).title("Macbook Pro 13").description("Mackbook Pro 13 inch laptop").manufactureID("APPLE").build(),
            Product.builder().id(UUID.randomUUID().toString()).title("Nokia Phone").description("Nokia phone wide screen").manufactureID("NOKIA").build(),
            Product.builder().id(UUID.randomUUID().toString()).title("Macbook Pro 15").description("Mackbook Pro 15 inch laptop").manufactureID("APPLE").build(),
            Product.builder().id(UUID.randomUUID().toString()).title("Mackbook Air").description("Macbook Air 13 inch laptop").manufactureID("APPLE").build(),
        };
        return Arrays.asList(products);
    }

    public List<Product> getAllProducts() {
        String sql = "SELECT id, title, category, description, manufacture_id FROM Product";

        List<Map<String, Object>> rows =jdbcTemplate.queryForList(sql);
        List<Product> result = new ArrayList<>();

        for(Map<String, Object> row : rows) {
            Manufacture manufacture = manufactureRepository.getManufactureById((String) row.get("manufacture_id"));
            result.add(Product.builder()
                    .id((String) row.get("id"))
                    .category((String) row.get("category"))
                    .description((String) row.get("description"))
                    .title((String) row.get("title"))
                    .madeBy(manufacture)
                    .build());
        }
        return result;
    }

    public List<Product> getRecentPurchases(final Integer count) {
        List<Product> products =  getAllProducts();
        return products.subList(0, count);
    }

    public List<Product> getLastVisitedPurchases(final Integer count) {
        List<Product> products = getAllProducts();

        return products.subList(0, count);
    }

    public List<Product> getProductsByCategory(final String category) {
        String sql = "SELECT id,title,category,description,manufacturer_id FROM Product WHERE category=?";

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, category);
        List<Product> result = new ArrayList<Product>();

        for (Map<String, Object> row : rows) {
            Manufacture manufacture = manufactureRepository.getManufactureById((String) row.get("manufacturer_id"));
            result.add(Product.builder()
                    .id((String) row.get("id"))
                    .category((String) row.get("category"))
                    .description((String) row.get("description"))
                    .title((String) row.get("title"))
                    .madeBy(manufacture)
                    .build());
        }

        return result;
    }

}
