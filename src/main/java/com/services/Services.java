package com.services;

import com.Repo.MyRepo;
import com.Repo.productRepo;
import com.model.Product;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Services {

    @Autowired
    private MyRepo myRepo;

    @Autowired
    private productRepo productRepo;

    public boolean register(String email, String password, String name, String address, String phone) {
        if (name.equals("") || email.equals("") || password.equals("") || address.equals("") || phone.equals(""))
            return false;

        User user = new User(email, password, name, address, phone);
        myRepo.save(user);
        return true;
    }

    public boolean loginVerify(String email, String password) {
        User user = myRepo.findByEmail(email);
        if (user != null && user.getEmail().equals(email) && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    public boolean isAdmin(String email, String password) {
        return (email.equals("pkkashyap616@gmail.com") && password.equals("12"));
    }

    public List<Product> getAllProduct() {
        return (List<Product>) productRepo.findAll();
    }

    public boolean addProduct(String name, String brand, String madeIn, String price, String date) {
        Product product = new Product(name, brand, madeIn, price, date);
        try {
            productRepo.save(product);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public boolean deleteProduct(int id) {
        try {
            productRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Product> searchProduct(String name) {
        return productRepo.findByProductNameOrBrand(name, name);
    }

    public boolean updateProduct(int id, String name, String brand, String madeIn, String price, String date) {
        try {
            Product product = productRepo.findById(id);

            product.setProductName(name);
            product.setBrand(brand);
            product.setMadeIn(madeIn);
            product.setPrice(price);
            product.setPurchaseDate(date);
            productRepo.save(product);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Product getProductById(int id){
        return productRepo.findById(id);
    }
}
