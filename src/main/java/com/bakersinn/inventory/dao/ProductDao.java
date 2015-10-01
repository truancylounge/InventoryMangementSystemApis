package com.bakersinn.inventory.dao;

import com.bakersinn.inventory.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
/**
 * Created by Lalith on 9/23/15.
 */
public class ProductDao implements ProductDaoInterface {
    @Override
    public Product getProductById(Integer id) {
        return null;
    }

    @Override
    public Product deleteProductById(Integer id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {

        System.out.println("Inside getAll Products DAO");

        List<Product> products = new ArrayList<Product>();
        try{
            SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
            dataSource.setDriver(new com.mysql.jdbc.Driver());
            dataSource.setUrl("jdbc:mysql://localhost/inventory");
            dataSource.setUsername("root");
            //dataSource.setPassword("P@ssw0rd");
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            String sql = "select * from products";

            List<Product> productList = jdbcTemplate.query(sql, new RowMapper<Product>() {

                public Product mapRow(ResultSet result, int rowNum) throws SQLException {
                    Product product = new Product();
                    product.setId(result.getInt("id"));
                    product.setProductName(result.getString("productName") == null ? null : result.getString("productName").trim());
                    product.setProductCode(result.getString("productCode") == null ? null : result.getString("productCode").trim());
                    product.setProductType(result.getString("productType") == null ? null : result.getString("productType").trim());
                    product.setSellingRate(result.getDouble("sellingRate"));
                    product.setCostRate(result.getDouble("costRate"));
                    return product;
                }

            });
            products = productList;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.print("Number of products : " + products.size());
        return products;
    }

    @Override
    public Product insertProduct(Product product) {
        return null;
    }

    @Override
    public List<Product> insertAllProducts(List<Product> products) {
        return null;
    }

    @Override
    public Product updateProduct(Product product) {
        return null;
    }
}
