package com.app.dependency.qualifier.task;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class Vips implements Restaurant {
    private int price;
    @Override
    public Boolean getBar() {
        return false;
    }

    @Override
    public void setPrice(int price) {
        this.price = PRICE + price;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
