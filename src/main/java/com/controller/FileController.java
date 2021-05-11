package com.controller;

import com.services.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/mainApp")
public class FileController {

    @Autowired
    private Services services;

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/signIn{logout}")
    public String login(@PathVariable("logout") String logout, ModelMap map) {
        if (logout.contains("logout"))
            map.put("logout", "Logged out successfully");
        return "signIn";
    }

    @GetMapping("/adminHome")
    public String adminHome(ModelMap map) {
        map.put("products", services.getAllProduct());
        return "adminHome";
    }

    @GetMapping("/addProduct")
    public String addProduct() {
        return "addProduct";
    }

    @GetMapping("/delete-product")
    public String deleteProduct(@RequestParam int id, ModelMap map) {
        if (services.deleteProduct(id)) {
            map.put("message", "deleted product with id " + id);
        } else {
            map.put("message", "product not deleted with id " + id);
        }
        map.put("products", services.getAllProduct());
        return "redirect:/mainApp/adminHome";
    }

    @GetMapping("/update-product")
    public String updateProduct(@RequestParam int id, ModelMap map) {
        map.put("product", services.getProductById(id));
        return "updateProduct";
    }

    @GetMapping("/userList")
    public String userList(ModelMap map) {
        map.put("users", services.getAllUser());
        return "userList";
    }

    @GetMapping("/passwordChange")
    public String changePassword() {
        return "passwordChange";
    }

    @GetMapping("/userHome")
    public String userHome(ModelMap map) {
        map.put("products", services.getAllProduct());
        return "userHome";
    }
}
