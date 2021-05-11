package com.controller;

import com.services.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
@RequestMapping("/mainApp")
public class mainApp {
    private String currentUserEmail = "";
    @Autowired
    private Services services;

    @PostMapping("/home")
    public String home() {
        return "home";
    }

    @PostMapping("/register")
    public String register(@RequestParam("email") String email, @RequestParam("password") String password,
                           @RequestParam("name") String name, @RequestParam("address") String address, @RequestParam("phone") String phone,
                           ModelMap map) {
        if (services.register(email, password, name, address, phone)) {
            return "regSuccess";
        } else {
            map.put("message","Email or phone already exists....");
            return "register";
        }
    }

    @PostMapping("/signIn")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, ModelMap map) {
        if (services.loginVerify(email, password)) {
            map.put("name", services.getNameOfUser(email));
            currentUserEmail = email;
            map.put("email", email);
            if (services.isAdmin(email, password)) {
                return "adminHome";
            }

            return "redirect:/mainApp/userHome";
        }
        map.put("message", "INVALID LOGIN");
        return "signIn";
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

    @PostMapping("/userList")
    public String searchUser(@RequestParam("search") String name, ModelMap map) {
        map.put("users", services.searchUser(name));
        return "userList";
    }

    @PostMapping("/update-product")
    public String updateProduct(@RequestParam int id, @RequestParam("name") String name, @RequestParam("brand") String brand,
                                @RequestParam("madeIn") String madeIn, @RequestParam("price") String price, @RequestParam("date") String date) {
        if (services.updateProduct(id, name, brand, madeIn, price, date)) {
            return "redirect:/mainApp/adminHome";
        } else {
            return "redirect:/mainApp/adminHome";
        }
    }

    @PostMapping("/passwordChange")
    public String changePassword(@RequestParam("currentPassword") String currentPassword, @RequestParam("newPassword") String newPassword,
                                 @RequestParam("reNewPassword") String reNewPassword, ModelMap map) {
        if (services.changePassword(currentUserEmail, currentPassword, newPassword, reNewPassword)) {
            map.put("message", "Password changed successfully");
        } else {
            map.put("message", "Password not changed !!!!");
        }

        return "passwordChange";
    }
}
