package com.example.md4_ss15_baith3_uploadfile.controller;

import com.example.md4_ss15_baith3_uploadfile.model.Product;
import com.example.md4_ss15_baith3_uploadfile.model.ProductForm;
import com.example.md4_ss15_baith3_uploadfile.service.IProductService;
import com.example.md4_ss15_baith3_uploadfile.service.ProductServiceIMPL;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = {"/","/product"})
public class ProductController {
    @Value("${file-upload}")
    private String fileUpload;

    private final IProductService productService = new ProductServiceIMPL();

    @GetMapping("")
    public String index(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "/index";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("productForm", new ProductForm());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveProducts(@ModelAttribute ("productForm") ProductForm productForm) {
        List<MultipartFile> files = productForm.getImage();
        List<String> fileNames = new ArrayList<>();
        try {
            System.out.println("in");
            for (MultipartFile file : files) {
                String fileName = file.getOriginalFilename();
                FileCopyUtils.copy(file.getBytes(), new File(fileUpload + fileName));
                fileNames.add(fileName);
            }
            Product product = new Product(productForm.getId(), productForm.getName(), productForm.getDescription(), new ArrayList<>(fileNames));
            System.out.println(product);
            productService.save(product);
        } catch (IOException ex) {
            System.out.println("out");
            ex.printStackTrace();
        }
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("message", "Created new products successfully !");
        return modelAndView;
    }
}
