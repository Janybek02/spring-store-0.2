package com.example.web_store02.controller;

import com.example.web_store02.models.Products;
import com.example.web_store02.productsDAO.ProductsDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductsController {
    private final ProductsDAO productsDAO;

    public ProductsController(ProductsDAO productsDAO) {
        this.productsDAO = productsDAO;
    }

    @GetMapping("")
    public String allProducts(Model model) {
        model.addAttribute("products", productsDAO.getProductsList());
        return "products/main";
    }
    @GetMapping("/save")
    public String saveProduct(Model model) {
        model.addAttribute("saveProducts", new Products());
        return "products/save";
    }

    @PostMapping()
    public String showProducts(@ModelAttribute("products") Products products) {
        productsDAO.saveProducts(products);
    return "redirect:/products";
    }

}
