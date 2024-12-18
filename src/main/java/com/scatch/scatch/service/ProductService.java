package com.scatch.scatch.service;

import com.scatch.scatch.model.ProductModel;
import com.scatch.scatch.repository.ProductRepository;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository prdRepo;


    public void addProduct(MultipartFile image, String name,
                           Double price, Double discount,
                           String backgroundColor, String panelColor,
                           String textColor) throws IOException{


        ProductModel product = new ProductModel(name,price,discount,backgroundColor,panelColor,textColor);

        product.setImage(
                new Binary(BsonBinarySubType.BINARY, image.getBytes())
        );

        product = prdRepo.save(product);
    }

    public Binary getImageVa(String id) {
        return prdRepo.findById(id).get().getImage();
    }

    public List<ProductModel> findAllProducts() {
        return prdRepo.findAll();
    }

    public ProductModel findById(String prodId) {
        return prdRepo.findById(prodId).get();
    }
}
