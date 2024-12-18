package com.scatch.scatch.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;
import java.util.List;

@Document(collection = "owner")
public class OwnerModel {


    @Id
    private int id;
    private String full_name;
    private String email;
    private String password;
    private List<ProductModel> products;
    private byte[] picture;
    private String gstno;

    public OwnerModel(String full_name, String email, String password, List<ProductModel> products, byte[] picture, String gstno) {
        this.full_name = full_name;
        this.email = email;
        this.password = password;
        this.products = products;
        this.picture = picture;
        this.gstno = gstno;
    }

    public OwnerModel(){

    }

    @Override
    public String toString() {
        return "Owner{" +
                "full_name='" + full_name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", products=" + products +
                ", picture=" + Arrays.toString(picture) +
                ", gstno='" + gstno + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ProductModel> getProducts() {
        return products;
    }

    public void setProducts(List<ProductModel> products) {
        this.products = products;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getGstno() {
        return gstno;
    }

    public void setGstno(String gstno) {
        this.gstno = gstno;
    }
}
