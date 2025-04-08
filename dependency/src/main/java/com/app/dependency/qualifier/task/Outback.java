package com.app.dependency.qualifier.task;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Getter
public class Outback implements Restaurant {
    private int price;
    @Override
    public Boolean getBar() {
        return true;
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
