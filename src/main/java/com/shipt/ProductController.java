package com.shipt;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shipt.service.ProductService;
import com.shipt.service.ProductServiceImpl;
import com.shipt.model.Product;

@RestController
@RequestMapping("/product")
public class ProductController {
	
    private static final String template = "Product id: %s. Product name: %s! ";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value="/get/{id}", method=RequestMethod.GET)
    public Product getProduct(@PathVariable(value="id",required=false) int prodId) {
    	Product product = ServiceFactory.getServiceFactory().getProductServiceImpl().getProduct(prodId);
        return product;
    }

    @RequestMapping(value="/create/{name}/{unit}/{price}", method=RequestMethod.POST)
    public Product postProduct(@PathVariable(value="name", required=false) String prodName, @PathVariable(value="unit", required=false) int prodUnit, @PathVariable(value="price", required=false) int prodPrice) {
    	return ServiceFactory.getServiceFactory().getProductServiceImpl().createProduct(prodName, prodUnit, prodPrice);
    }
    
    @RequestMapping(value="/put/{id}/{name}", method=RequestMethod.PUT)
    public Product putProduct(@PathVariable(value="id", required=false) int prodId, @PathVariable(value="name", required=false) String prodName, @PathVariable(value="cost", required=false) int prodCost, @PathVariable(value="price", required=false) int prodPrice) {
    	Product changedProduct = ServiceFactory.getServiceFactory().getProductServiceImpl().updateProduct(prodId, prodName, prodCost, prodPrice);
    	return changedProduct;
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
    public Product deleteProduct(@PathVariable(value="id", required=false) int prodId) {
    	ServiceFactory.getServiceFactory().getProductServiceImpl().deleteProduct(prodId);
    	return new Product(prodId,String.format("Deleted Product id: %s! ", prodId),1,1);
    }

}
