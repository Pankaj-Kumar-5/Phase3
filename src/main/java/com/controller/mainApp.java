package com.controller;

import com.services.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/mainApp")
public class mainApp {

    @Autowired
    private Services services;

    @PostMapping("/home")
    public String home() {
        return "home";
    }

    @PostMapping("/register")
    public String register(@RequestParam("email") String email, @RequestParam("password") String password,
                           @RequestParam("name") String name, @RequestParam("address") String address, @RequestParam("phone") String phone) {
        if (services.register(email, password, name, address, phone)) {
            return "regSuccess";
        } else {
            return "Please try again";
        }
    }

    @PostMapping("/signIn")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password) {
        if (services.loginVerify(email, password)) {
            if (services.isAdmin(email, password)) {
                return "redirect:/mainApp/adminHome";
            }
            return "success";
        }
        return "redirect:/mainApp/signIn";
    }

    @PostMapping("/addProduct")
    public String addProduct(@RequestParam("name") String name, @RequestParam("brand") String brand,
                             @RequestParam("madeIn") String madeIn, @RequestParam("price") String price, @RequestParam("date") String date) {
        if (services.addProduct(name, brand, madeIn, price, date)) {
            return "redirect:/mainApp/adminHome";
        }

        return "failed";
    }

    @PostMapping("/adminHome")
    public String searchProduct(@RequestParam("search") String name, ModelMap map) {
        map.put("products", services.searchProduct(name));
        return "adminHome";
    }

    @PostMapping("/update-product")
    public String updateProduct(@RequestParam int id, @RequestParam("name") String name, @RequestParam("brand") String brand,
                                @RequestParam("madeIn") String madeIn, @RequestParam("price") String price, @RequestParam("date") String date) {
        if (services.updateProduct(id, name, brand, madeIn, price, date)) {
            System.out.println("updated");
            return "redirect:/mainApp/adminHome";
        } else {
            return "redirect:/mainApp/adminHome";
        }

    }

//    @PostMapping("/delete-product")
//    public String deleteProduct(){
//
//    }


}
