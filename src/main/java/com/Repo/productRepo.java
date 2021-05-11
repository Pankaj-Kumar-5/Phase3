package com.Repo;

import com.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface productRepo extends CrudRepository<Product,Integer> {
    public List<Product> findByProductNameOrBrandOrPurchaseDate(String productName,String brand,String date);
    public Product findById(int id);
}
