# Luxury Bag Website

A premium luxury bag website built with Spring Boot 3 and Spring Security 6.

## Features

1. **Login and Register Page**  
   Accessible at `localhost:8081/`  
   ![Login and Register](src/main/resources/static/images/indexPage.png)  

2. **Password Encryption**  
   User passwords are stored securely in the database using BCrypt encryption.  

3. **Authentication**  
   Spring Security 6 is used to handle authentication and user authorization.  

4. **Create Product Feature**  
   Admins can create products at `localhost:8081/product/create`.  
   ![Create Product](src/main/resources/static/images/CreateProductPage.png)  

5. **Shop Feature**  
   A shopping page where all products are listed at `localhost:8081/shop`.  
   ![Shop](src/main/resources/static/images/ShopPage.png)  

6. **Cart Feature**  
   Users can view and manage their cart at `localhost:8081/cart`.  
   ![Cart](/src/main/resources/static/images/CartPage.png)

7. **MongoDB Integration**  
   The application is connected to a MongoDB database to store user, product, and order information.

8. **Logout Feature**    
   Users can log out of the system. Once logged out, they are redirected to the login page.

## Planned Features

- **Filter Products**: Ability to filter products by popularity, newest, etc.
- **Account Details**: User account management and profile details.
- **Payment Gateway**: Integration with a payment gateway for transactions.
- **OAuth2 Login**: GitHub and Google OAuth2 login functionality for easier authentication.

---
