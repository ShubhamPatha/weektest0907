# weektest0907

## FRAMEWORK AND LANGUAGE USED
* JAVA 17
* MAVEN
* SPRINGBOOT 3.1.1
* MySQl 
<!-- Headings -->   
## DATA FLOW

<!-- Code Blocks -->

### CONTROLLER

#### AddressController
  ``` 
package com.geekster.usermodel.controller;

import com.geekster.usermodel.model.Address;
import com.geekster.usermodel.model.Product;
import com.geekster.usermodel.model.User;
import com.geekster.usermodel.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
    @Autowired
    AddressService addressService;
    @PostMapping("Add_Address")
    public void AddAddress(@RequestBody Address address)
    {
        addressService.addAddresss(address);
    }


}

```
#### OrderController
  ```
package com.geekster.usermodel.controller;


import com.geekster.usermodel.model.Order1;
import com.geekster.usermodel.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
 public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("create_order")
    public void createorder(@RequestBody Order1 order)
    {
        orderService.addOrder(order);
    }

    @GetMapping("order/{id}")
    public Order1 getOrderById(@PathVariable Integer id){
        return orderService.getorderbyid(id);
    }



}


```
#### ProductController
  ``` 

package com.geekster.usermodel.controller;

import com.geekster.usermodel.model.Order1;
import com.geekster.usermodel.model.Product;
import com.geekster.usermodel.model.User;
import com.geekster.usermodel.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @PutMapping("product/{id}")
    public void deleteproduct(@PathVariable Integer id)
    {
        productService.removeproduct(id);
    }

    @PostMapping("Add_Product")
    public void AddProduct(@RequestBody Product product)
    {productService.addProduct(product);
    }

    @GetMapping("product")
    public Iterable<Product>  getAllproduct(@PathVariable Integer id){
        return productService.getAllproduct(id);
    }





}

```
#### UserController
  ```
package com.geekster.usermodel.controller;

import com.geekster.usermodel.model.Order1;
import com.geekster.usermodel.model.User;
import com.geekster.usermodel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

@Autowired
UserService userService;
    @PostMapping("Create_User")
    public void createUser(@RequestBody User user)
    {
        userService.addUser(user);
    }
    @GetMapping("user/{id}")
    public Order1 getOrderById(@PathVariable Integer id){
        return userService.getuserbyid(id);
    }





}


```


 ### MODEL
  #### Address
  ``` 
package com.geekster.usermodel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Address_id;
    private String Address_name;
    private String Address_landmark;
    private String Address_phoneNumber;
    private String Address_zipcode;
    private String Address_state;
//mappings
    @OneToOne
        @JoinColumn(name ="USER_ID_FK")
    User user;


}

```
#### Order
  ``` 
package com.geekster.usermodel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Order1 {
    @Id
    private Integer order_id;
    @OneToOne
    @JoinColumn(name="user_id")
    User user;


    @OneToOne
    @JoinColumn(name="product_id")
    Product product;


    @OneToOne
    @JoinColumn(name="Address_id")
    Address address;

   private Integer order_productQuantity;
}

```
#### Product
  ```
package com.geekster.usermodel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer product_id;
    private String product_name;
    private Integer product_price;
    private String product_description;
    private String product_category;
    private String product_brand;
}


```
#### User
  ```
package com.geekster.usermodel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;
    private String user_name;
    private String user_email;
    private String user_password;
    private String user_phonenumber;
}


```


### Repository
#### Iaddress
  ``` 
package com.geekster.usermodel.repository;

import com.geekster.usermodel.model.Address;
import com.geekster.usermodel.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Iaddress extends CrudRepository<Address,Integer> {
}


```

#### Iorder
  ```
package com.geekster.usermodel.repository;

import com.geekster.usermodel.model.Order1;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Iorder extends CrudRepository<Order1,Integer> {

    @Query(value = "select * from order1 where order_id= :id" , nativeQuery = true)
    Order1 getorderbyId(Integer id);
}



```
#### Iproduct
  ``` 
package com.geekster.usermodel.repository;

import com.geekster.usermodel.model.Product;
import com.geekster.usermodel.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Iproduct extends CrudRepository<Product,Integer> {
}


```

#### Iuser
  ``` 
package com.geekster.usermodel.repository;

import com.geekster.usermodel.model.Order1;
import com.geekster.usermodel.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Iuser extends CrudRepository<User,Integer> {
    @Query(value = "select * from user where user_id= :id" , nativeQuery = true)
    Order1 getuserbyId(Integer id);
}


```


### SERVICE

#### Address Service
  ``` 
  package com.geekster.usermodel.service;

import com.geekster.usermodel.model.Address;

import com.geekster.usermodel.repository.Iaddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    Iaddress iaddress;




    public void addAddresss(Address k) {
        iaddress.save(k);

    }
}



```
#### Order SERVICE
  ``` 
  
package com.geekster.usermodel.service;

import com.geekster.usermodel.model.Order1;
import com.geekster.usermodel.repository.Iorder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    Iorder iorder;

    public  void addOrder(Order1 order) {
        iorder.save(order);
    }


    public Order1 getorderbyid(Integer id) {
        return  iorder.getorderbyId(id);
    }
}


```
####  Product SERVICE
  ``` 
  package com.geekster.usermodel.service;

import com.geekster.usermodel.model.Product;
import com.geekster.usermodel.repository.Iproduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    Iproduct iproduct ;

    public  void addProduct(Product product) {
        iproduct.save(product);
    }


    public Iterable<Product> getAllproduct(Integer id) {
        return iproduct.findAll();
    }

    public void removeproduct(Integer id) {
        iproduct.deleteById(id);
    }
}



```
#### User SERVICE
  ``` 
  
package com.geekster.usermodel.service;

import com.geekster.usermodel.model.Order1;
import com.geekster.usermodel.model.User;
import com.geekster.usermodel.repository.Iuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    Iuser iuser;


    public  void addUser(User user) {
        iuser.save(user);
    }

    public Order1 getuserbyid(Integer id) {
        return iuser.getuserbyId(id);
    }
}


```


### UsermodelApplication
  ``` 
package com.geekster.usermodel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UsermodelApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsermodelApplication.class, args);
	}

}



```

 ### Application Properties
  ```
spring.datasource.url=jdbc:mysql://localhost:3306/DB1
spring.datasource.username=root
spring.datasource.password=Shubham12@
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update

spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.use_sql_comments=true
spring.jpa.properties.hibernate.format_sql=true
```


 ### POM
  ``` 
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.1.1</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.geekster</groupId>
	<artifactId>usermodel</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>usermodel</name>
	<description>Demo project for Spring Boot</description>
	<properties>
		<java.version>17</java.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>com.mysql</groupId>
			<artifactId>mysql-connector-j</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springdoc</groupId>
			<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
			<version>2.1.0</version>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<excludes>
						<exclude>
							<groupId>org.projectlombok</groupId>
							<artifactId>lombok</artifactId>
						</exclude>
					</excludes>
				</configuration>
			</plugin>
		</plugins>
	</build>

</project>

```
## DATA STRUCTURE USED
* LIST 
* STRING
* LOCAL DATE
* INTEGER
* USER

# PROJECT SUMMARY

## Spring Project Ecommerce API Has been created with the following attribute
```
User Model:
   Id:integer
    name:string
    email:string
   password:string
   phoneNumber:string
Product Model:
       id:integer 
         name:string
         price:integer
         description:string
       category:string
       brand:string

Address Model:
       id:integer    
       name:string
       landmark:string
       phoneNumber:string
       zipcode:string
       state:string
       UserID : foreign key mapping

Order Model:
    id:integer
    userID:integer (foreign key mapping)
    productID:integer(foreign key mapping)
    addressID:integer(foreign key mapping)
    productQuantity:integer


```






<!-- Headings -->   
# Author
SHUBHAM PATHAK
 <!-- UL -->
* Twitter <!-- Links -->
[@ShubhamPathak]( https://twitter.com/Shubham15022000)
* Github  <!-- Links -->
[@ShubhamPathak]( https://github.com/ShubhamPatha)
<!-- Headings -->   
