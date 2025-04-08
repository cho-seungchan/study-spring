package com.app.dependency.qualifier.task;

public interface Restaurant {
    static final int PRICE = 1000;
    public Boolean getBar();
    public void setPrice(int price);
    public int getPrice();
}
