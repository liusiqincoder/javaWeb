package com.dao.enterties;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/9/22.
 */
public class User {
    private String name, password;
    private shoppingCar car = new shoppingCar();

    public User() {

    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public void buy(String thingName, int num) {
        thing t = new thing(thingUtil.getDesc(thingName), thingName, thingUtil.getPrice(thingName));
        t.setNum(num);
        car.addThing(t);
    }

    public ArrayList<thing> getBuyThing() {
        return car.getAllThing();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public shoppingCar getCar() {
        return car;
    }

    public void setCar(shoppingCar car) {
        this.car = car;
    }

    public void dropNum(String name) {
        car.dropNum(name);
    }

    public void addNum(String name) {
        car.addNum(name);
    }
}
