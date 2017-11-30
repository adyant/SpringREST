package com.shipt;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shipt.model.Category;
import com.shipt.model.ProductWrapper;

@RestController
@RequestMapping("/category")
public class CategoryController {
	

    @RequestMapping(value="/get/{id}", method=RequestMethod.GET)
    public Category getCategory(@PathVariable(value="id",required=false) int catid) {
    	Category category = ServiceFactory.getServiceFactory().getCategoryServiceImpl().getCategory(catid);
        return category;
    }

    @RequestMapping(value="/create/{name}", method=RequestMethod.POST)
    public Category postCategory(@PathVariable(value="name", required=false) String catname){
    	Category newCategory= ServiceFactory.getServiceFactory().getCategoryServiceImpl().createCategory(catname);
    	return newCategory;
    }
    
    @RequestMapping(value="/update/{id}/{name}", method=RequestMethod.PUT)
    public Category putCategory(@PathVariable(value="id", required=false) int catid, @PathVariable(value="name", required=false) String catname) {
    	Category newCategory = ServiceFactory.getServiceFactory().getCategoryServiceImpl().updateCategory(catid,catname);
    	return newCategory;
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
    public Category deleteCategory(@PathVariable(value="id", required=false) int catid) {
    	ServiceFactory.getServiceFactory().getCategoryServiceImpl().deleteCategory(catid);
    	return new Category(catid,String.format("Category id: %s! ", catid));
    }
    
    @RequestMapping(value="/addProduct/{id}", method=RequestMethod.PUT)
    public Category addProduct(@PathVariable(value="id", required=false) int catid, @RequestBody ProductWrapper productWrapper) {
    	return ServiceFactory.getServiceFactory().getCategoryServiceImpl().addProduct(catid, productWrapper.getProduct());
    }
	  
    
    
    
}
