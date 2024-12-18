# Luxury Bag Website

A premium luxury bag website built with Spring Boot 3 and Spring Security 6.

## Features

1. **Login and Register Page**  
   Accessible at `localhost:8081/`  
   ![Login and Register](/src/main/resources/static/images/CartPage.png)  

2. **Password Encryption**  
   User passwords are stored securely in the database using BCrypt encryption.  

3. **Authentication**  
   Spring Security 6 is used to handle authentication and user authorization.  

4. **Create Product Feature**  
   Admins can create products at `localhost:8081/product/create`.  
   ![Create Product](image-placeholder)  

5. **Shop Feature**  
   A shopping page where all products are listed at `localhost:8081/shop`.  
   ![Shop](image-placeholder)  

6. **Cart Feature**  
   Users can view and manage their cart at `localhost:8081/cart`.  
   ![Cart](image-placeholder)

7. **MongoDB Integration**
  The application is connected to a MongoDB database to store user, product, and order information.


## Planned Features

- **Filter Products**: Ability to filter products by popularity, newest, etc.
- **Account Details**: User account management and profile details.
- **Payment Gateway**: Integration with a payment gateway for transactions.
- **OAuth2 Login**: GitHub and Google OAuth2 login functionality for easier authentication.

---

Feel free to replace the image placeholders with the actual images and make any further adjustments as needed!
