package com.scatch.scatch.service;

import com.scatch.scatch.model.ProductModel;
import com.scatch.scatch.model.UserModel;
import com.scatch.scatch.repository.ProductRepository;
import com.scatch.scatch.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Autowired
    private ProductRepository prdRepo;

    public void addUser(UserModel user) {
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        try {
            userRepo.save(user);
            logger.info("User successfully saved to the database: {}", user);
        } catch (Exception e) {
            logger.info("Error while saving user: {}", e.getMessage());
            e.printStackTrace();
        }
    }

    public UserModel findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

//    public void addToCart(String prodId, String userEmail) {
//
//        UserModel user;
//        ProductModel product;
//        try {
//            user = userRepo.findByEmail(userEmail);
//            System.out.println("User is:- " + user);
//
//            product = prdRepo.findById(prodId).get();
//            System.out.println("Product is:- " + product);
//        }catch (Exception e) {
//            throw new RuntimeException("Error block1");
//        }
//
//        try{
//            user.getCart().add(product);
//        }
//        catch (Exception e) {
//            throw new RuntimeException("Error block2");
//        }
//
//        try{
//            userRepo.save(user);
//        }
//        catch (Exception e) {
//            throw new RuntimeException("Error block3");
//        }
//
//        System.out.println("UserCart is:- " + user.getCart());
//    }

//    public void addToCart(String prodId, String userEmail) {
//        UserModel user = userRepo.findByEmail(userEmail);
//        if (user == null) {
//            throw new RuntimeException("User not found with email: " + userEmail);
//        }
//
//        Optional<ProductModel> productOpt = prdRepo.findById(prodId);
//        if (productOpt.isEmpty()) {
//            throw new RuntimeException("Product not found with ID: " + prodId);
//        }
//        ProductModel product = productOpt.get();
//
//        // Add product to cart
//        try {
//            user.getCart().add(product);
//            userRepo.save(user);
//        } catch (Exception e) {
//            throw new RuntimeException("Error saving cart: " + e.getMessage());
//        }
//    }

    public void addToCart(String prodId, String userEmail) {
        // Validate input
        if (userEmail == null || prodId == null) {
            logger.error("Invalid input: userEmail or productId is null");
            throw new IllegalArgumentException("User email and product ID must not be null");
        }

        // Find user
        UserModel user = userRepo.findByEmail(userEmail);
        if (user == null) {
            logger.error("User not found with email: {}", userEmail);
            throw new RuntimeException("User not found with email: " + userEmail);
        }

        // Find product
        ProductModel product = prdRepo.findById(prodId)
                .orElseThrow(() -> {
                    logger.error("Product not found with ID: {}", prodId);
                    return new RuntimeException("Product not found with ID: " + prodId);
                });

        // Ensure cart is initialized
        if (user.getCart() == null) {
            logger.warn("User cart was null, initializing new cart for user: {}", userEmail);
            user.setCart(new ArrayList<>()); // Assuming you have a setCart method
        }

        // Check for duplicate items (optional)
        if (user.getCart().contains(product)) {
            logger.info("Product already in cart for user: {}", userEmail);
            return; // Or increment quantity if that's your requirement
        }

        // Add to cart and save
        try {
            user.getCart().add(product);
            userRepo.save(user);
            logger.info("Product added to cart successfully for user: {}", userEmail);
        } catch (Exception e) {
            logger.error("Error adding product to cart for user: {}", userEmail, e);
            throw new RuntimeException("Failed to add product to cart: " + e.getMessage(), e);
        }

        System.out.println(user.getCart());
    }


}
