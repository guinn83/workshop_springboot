package com.springcourse.course.config;

import com.springcourse.course.entities.Category;
import com.springcourse.course.entities.Order;
import com.springcourse.course.entities.Product;
import com.springcourse.course.entities.User;
import com.springcourse.course.entities.enums.OrderStatus;
import com.springcourse.course.repositories.CategoryRepository;
import com.springcourse.course.repositories.OrderRepository;
import com.springcourse.course.repositories.ProductRepository;
import com.springcourse.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public void run(String... args) throws Exception {
        List<Product> products = new ArrayList<>();
        products.add(new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""));
        products.add(new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""));
        products.add(new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""));
        products.add(new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""));
        products.add(new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""));

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(products);

        products.get(0).getCategories().add(cat2);
        products.get(1).getCategories().add(cat1);
        products.get(1).getCategories().add(cat3);
        products.get(2).getCategories().add(cat3);
        products.get(3).getCategories().add(cat3);
        products.get(4).getCategories().add(cat2);

        productRepository.saveAll(products);

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.DELIVERED, u1);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

    }
}
