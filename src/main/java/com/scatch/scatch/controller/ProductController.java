package com.scatch.scatch.controller;

import com.scatch.scatch.model.ProductModel;
import com.scatch.scatch.service.ProductService;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/create")
//    @PreAuthorize("hasRole('ADMIN')") do this in future
    public String viewCreateProduct(Model model) {
        model.addAttribute("product",new ProductModel());
        return "createproducts";
    }

    @PostMapping("/create")
    public String createProduct(@RequestParam MultipartFile image,
                                @RequestParam String name,
                                @RequestParam Double price,
                                @RequestParam Double discount,
                                @RequestParam String backgroundColor,
                                @RequestParam String panelColor,
                                @RequestParam String textColor,
                                RedirectAttributes redirectAttributes) throws IOException {

        try{
            productService.addProduct(image,name,price,discount,backgroundColor,panelColor,textColor);

            redirectAttributes.addFlashAttribute("success", "Product created successfully!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "redirect:/product/create";
    }

    @GetMapping("/photos/{id}")
    public String getPhoto(@PathVariable String id, Model model) {
        Binary image  = productService.getImageVa(id);
        model.addAttribute("prodId", id);
        return "viewPhoto";
    }

    @GetMapping("/photos/image/{id}")
    public ResponseEntity<byte[]> getPhotoImage(@PathVariable String id) {
        Binary image = productService.getImageVa(id);
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(image.getData());
    }


}
