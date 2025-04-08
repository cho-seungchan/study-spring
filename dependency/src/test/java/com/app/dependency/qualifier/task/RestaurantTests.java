package com.app.dependency.qualifier.task;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class RestaurantTests {
    @Autowired
    Restaurant restaurant;

    @Test
    public void testRestaurant() {
        log.info("Restaurant testRestaurant : {}", restaurant );
        restaurant.setPrice(-500);
        log.info("Restaurant SALADBAR : {}", restaurant.getBar() );
        log.info("Restaurant PRICE : {}", restaurant.getPrice());
    }

}
