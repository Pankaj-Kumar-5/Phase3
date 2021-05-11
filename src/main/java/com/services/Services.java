package com.services;

import com.Repo.AdminRepo;
import com.Repo.MyRepo;
import com.Repo.productRepo;
import com.model.Product;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Services {

    @Autowired
    private MyRepo myRepo;

    @Autowired
    private productRepo productRepo;

    @Autowired
    private AdminRepo adminRepo;


    public boolean register(String email, String password, String name, String address, String phone) {

        if (myRepo.findByEmail(email) != null || myRepo.findByPhone(phone) != null) {
            return false;
        }

        if (name.equals("") || email.equals("") || password.equals("") || address.equals("") || phone.equals("")) {
            return false;
        }

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
        return (email.equals("pkkashyap616@gmail.com") || (email.equals("test@gmail.com")));
    }

    public String getNameOfUser(String email) {
        User user = myRepo.findByEmail(email);
        return user.getName();
    }


    public List<Product> getAllProduct() {
        return (List<Product>) productRepo.findAll();
    }

    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        for (User user : myRepo.findAll()) {
            if (!user.getEmail().equals("pkkashyap616@gmail.com") && !(user.getEmail().equals("test@gmail.com"))) {
                users.add(user);
            }
        }
        return users;
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
        return productRepo.findByProductNameOrBrandOrPurchaseDate(name, name, name);
    }

    public List<User> searchUser(String name) {
        return myRepo.findByEmailOrNameOrPhone(name, name, name);
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

    public boolean changePassword(String email, String currentPass, String newPass, String reNewPass) {

        try {
            if (newPass.equals(reNewPass)) {
                User user = myRepo.findByEmail(email);
                if (user.getPassword().equals(currentPass)) {
                    System.out.println("email " + email);
                    System.out.println(user.getPassword());
                    user.setPassword(newPass);
                    myRepo.save(user);
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public Product getProductById(int id) {
        return productRepo.findById(id);
    }
}
