package com.scatch.scatch.model;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "products")
public class ProductModel {
    /*
    1. image
    2. name
    3. price
    4. discount
    5. `background_color`
    6. `panel_color`
    7. `text_color`
    */

    @Id
    private String id;

    private Binary image;
    private String name;
    private Double price;
    private Double discount;

    private String backgroundColor;
    private String panelColor;
    private String textColor;

    public ProductModel(String name, Double price, Double discount, String backgroundColor, String panelColor, String textColor) {
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.backgroundColor = backgroundColor;
        this.panelColor = panelColor;
        this.textColor = textColor;
    }

    public ProductModel(){

    }

    public String getId() {
        return id;
    }

    public Binary getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Double getDiscount() {
        return discount;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public String getPanelColor() {
        return panelColor;
    }

    public String getTextColor() {
        return textColor;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setImage(Binary image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public void setPanelColor(String panelColor) {
        this.panelColor = panelColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    @Override
    public String toString() {
        return "Product{" +
//                "id='" + id + '\'' +
                ", image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", backgroundColor='" + backgroundColor + '\'' +
                ", panelColor='" + panelColor + '\'' +
                ", textColor='" + textColor + '\'' +
                '}';
    }
}