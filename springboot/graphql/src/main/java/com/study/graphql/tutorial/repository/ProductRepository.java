package com.study.graphql.tutorial.repository;

import com.study.graphql.tutorial.entity.Product;
import jakarta.annotation.PostConstruct;
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
    private void initalize() {

        System.out.println("INITIALIZE ... ?");

        insertProducts(getProducts());



    }

    public void insertProducts(List<Product> products) {
        String sql = "INSERT INTO Product " +  "(id, title, description, rating, manufacture_id) VALUES (?, ?, ?, ?, ?)";

        System.out.println("INSERT PRODUCT DATA CHECK ... ???");
        System.out.println("THIS IS TESSST !!!!");

        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {


                System.out.println("THIS IS SET VALUE DATA CHECK : " + i);

                Product product = products.get(i);

                System.out.println("PRODUCT ID 1 : "  +  i + " :=> "+ product.getId());
                System.out.println("PRODUCT ID 2 : "  +  i + " :=> "+ product.getTitle());
                System.out.println("PRODUCT ID 3 : "  +  i + " :=> "+ product.getDescription());
                System.out.println("PRODUCT ID 4 : "  +  i + " :=> "+ product.getRating());
                System.out.println("PRODUCT ID 5 : "  +  i + " :=> "+ product.getMadeBy().getName());

//                if( i == 4 ) {
//                    return;
//                }
                ps.setString(1, product.getId());
                ps.setString(2, product.getTitle());
                ps.setString(3, product.getDescription());
                ps.setString(4, product.getRating());
                ps.setString(5, product.getMadeBy().getName());
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
            new Product(UUID.randomUUID().toString(), "Samsung TV", "Samsung Television", "SAMSUNG"),

//            Product.builder().id(UUID.randomUUID().toString()).title("Samsung TV").description("Samsung Television").madeBy.getName()"SAMSUNG").build(),
//            Product.builder().id(UUID.randomUUID().toString()).title("Macbook Pro 13").description("Macbook pro 13 inch laptop").manufacturerID("APPLE").build(),
//            Product.builder().id(UUID.randomUUID().toString()).title("Nokia Phone").description("Nokia phone wide screen").manufacturerID("NOKIA").build(),
//            Product.builder().id(UUID.randomUUID().toString()).title("Macbook Pro 15").description("Macbook pro 15 inch laptop").manufacturerID("APPLE").build(),
//            Product.builder().id(UUID.randomUUID().toString()).title("Macbook air").description("Macbook air 13 inch laptop").manufacturerID("APPLE").build()
//

        };

        return Arrays.asList(products);
    }

    public List<Product> getAllProducts() {
        String sql = "SELECT id, title, category, description, manufacturer_id FROM Product";
        List<Map<String, Object>> rows =jdbcTemplate.queryForList(sql);

        List<Product> result = new ArrayList<>();

       for(Map<String, Object> row : rows) {
           Manufacture manufacturer = manufactureRepository.getManufacturerById((String) row.get("manufacturer_id"));
           result.add(Product.builder()
                   .id((String) row.get("id"))
                   .category((String) row.get("category"))
                   .description((String) row.get("description"))
                   .title((String) row.get("title"))
                   .madeBy(manufacturer)
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

            Manufacture manufacturer = manufactureRepository.getManufacturerById((String) row.get("manufacturer_id"));
            result.add(Product.builder()
                    .id((String) row.get("id"))
                    .category((String) row.get("category"))
                    .description((String) row.get("description"))
                    .title((String) row.get("title"))
                    .madeBy(manufacturer)
                    .build());
        }

        return result;
    }

}
