package com.scatch.scatch.controller;

import com.scatch.scatch.model.ProductModel;
import com.scatch.scatch.model.UserModel;
import com.scatch.scatch.service.ProductService;
import com.scatch.scatch.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);


    @Autowired
    private ProductService prdService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("userAttribute", new UserModel());
        return "index";
    }

    @GetMapping("/home")
    public String Home(){
        return "redirect:/shop";
    }

    @GetMapping("/shop")
    public String Shop(Model model){
        List<ProductModel> products = prdService.findAllProducts();
        model.addAttribute("products", products);
        return "shop";
    }

    @GetMapping("/addToCart/{prodId}")
    public String addToCart(@PathVariable String prodId,
                            Model model,
                            RedirectAttributes redirectAttributes) {

        // Get the currently logged-in user's email
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        try {
            userService.addToCart(prodId, email);
            logger.info("product added to cart");
            redirectAttributes.addFlashAttribute("success", "Product successfully added to Cart!");
        } catch (Exception e) {
            logger.info("Failed to add product to Cart");
            redirectAttributes.addFlashAttribute("error", "Failed to add product to Cart: " + e.getMessage());
        }

        return "redirect:/shop";  // Redirect to the shop page
    }

    @GetMapping("/cart")
    public String cart(Model model){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        UserModel user = userService.findByEmail(email);

        List<ProductModel> products = user.getCart();
        model.addAttribute("products", products);
//        ProductModel product = user.getCart().get(0);
//        model.addAttribute("product", product);


        return "/cart";
    }


}
