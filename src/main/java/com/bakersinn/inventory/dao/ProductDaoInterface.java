package com.bakersinn.inventory.dao;
import com.bakersinn.inventory.model.Product;
import java.util.List;

/**
 * Created by Lalith on 9/23/15.
 */
public interface ProductDaoInterface {
    public Product getProductById(Integer id);
    public Product deleteProductById(Integer id);
    public List<Product> getAllProducts();
    public Product insertProduct(Product product);
    public List<Product> insertAllProducts(List<Product> products);
    public Product updateProduct(Product product);
}
