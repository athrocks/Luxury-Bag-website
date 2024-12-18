package com.scatch.scatch.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;
import java.util.List;

@Document(collection = "users")  // This tells MongoDB to use the "users" collection
public class UserModel {
    /*
    1. full name - string
    2. email - string
    3. passwd - string
    4. cart - array
    6. orders - array
    7. contact - number
    8. picture - database
    */

    @Id
    private String id;
    private String fullname;
    private String email;
    private String password;

    @DBRef
    private List<ProductModel> cart;
    private List<Object> orders;
    private Long contact;
    private byte[] picture;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    public List<ProductModel> getCart() {
        return cart;
    }

    public void setCart(List<ProductModel> cart) {
        this.cart = cart;
    }

    public List<Object> getOrders() {
        return orders;
    }

    public void setOrders(List<Object> orders) {
        this.orders = orders;
    }

    public Long getContact() {
        return contact;
    }

    public void setContact(Long contact) {
        this.contact = contact;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }


    public UserModel() {
    }



    @Override
    public String toString() {
        return "User{" +
                "full_name='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", cart=" + cart +
                ", orders=" + orders +
                ", contact=" + contact +
                ", picture=" + Arrays.toString(picture) +
                '}';
    }



    public UserModel(String full_name, String email, String password, List<ProductModel> cart, List<Object> orders, Long contact, byte[] picture) {
        this.fullname = full_name;
        this.email = email;
        this.password = password;
        this.cart = cart;
        this.orders = orders;
        this.contact = contact;
        this.picture = picture;
    }

}
