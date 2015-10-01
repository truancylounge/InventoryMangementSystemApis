package com.bakersinn.inventory.resources;

import com.bakersinn.inventory.dao.ProductDao;
import com.bakersinn.inventory.model.Product;
import org.slf4j.Logger;
import static org.slf4j.LoggerFactory.getLogger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/products")
public class ProductResource {
    private static final Logger LOGGER = getLogger(ProductResource.class);
    /**
     * Method handling HTTP GET requests. The returned object will be sent to
     * the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("/ping")
    @Produces(MediaType.TEXT_PLAIN)
    public String ping() {
        //LOGGER.info("Inside GET for Ping");
        System.out.print("Inside GET for Ping");
        return "Success!!";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getAll() {
        //LOGGER.info("Inside GET all Products.");
        System.out.print("Inside GET all Products");
        ProductDao productDao = new ProductDao();
        return productDao.getAllProducts();
    }
}
