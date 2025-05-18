# Spring Boot WebApi Sample Project

This is a short demo of a spring boot web application for CRUD operations
(Create, Read, Update, Delete)

## Description
- IDE : InteliJ IDEA CE
- For demonstration purposes I used only one Entity class (Product) which is inherited from sealed class Item (Java 17+ feature).
- This shows how you can map a child class as an Entity.
- For storing the data I've used SQLite in a table called "product" in webapi.db database (all columns are mapped in parent and child classes : Item and Product)
- Used dependency injection to inject the ProductRepository interface in ProductService which is responsible to call the functions provided by JpaRepository interface.
- In ProductController I defined the endpoints for CRUD operations:
    - api/products - Get all products
    - api/product/{id} - Get a product with the specified id
    - api/add-product - Add a product
    - api/update-product/{id} - Update product with the specified id
    - api/delete-product/{id} - Delete a product with the specified id.
- For a better visualization I've added Swagger UI ( type after the port number of your localhost: /swagger-ui/index.html )
- In SecurityConfig I have created small basic authentication, different roles can acces different endpoints: USER only for GET and ADMIN for all.
- credentials for user: user / password
- credentials for admin: admin / admin
- If calling from Postman and want to try different credentials, you have to restart the server because the credentials are stored in memory so they will not change after first log in
- If you are using Swagger, tyoe after the port number: /login and to log out: /logout
- I have also added a custom Exception for when there is no record in the Database when we GET a product with an id that doesn't exist.
- For logging informations/errors to a file called "log_file.log" I used slf4j logger. If the file does not exists, it will be created in the app folder.
- As a quick scenario of saving a product, I've made a simple test case with junit and mockito.
- For creating the table in the database, I used DB Browser for SQLite ( as shown in this demo, the Database and Table aleady exists ).
