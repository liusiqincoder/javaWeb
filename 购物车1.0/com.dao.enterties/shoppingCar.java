package com.dao.enterties;

import java.util.*;

/**
 * Created by Administrator on 2018/9/30.
 * 用户的购物车类
 */
public class shoppingCar {
    private HashMap<String, thing> buyItem = new HashMap<>();

    public ArrayList<thing> getAllThing() {
        Set<String> keys = buyItem.keySet();
        ArrayList<thing> res = new ArrayList<thing>();
        for (String s : keys) {
            res.add(buyItem.get(s));
        }
        return res;
    }

    public void addThing(thing t) {
        if (buyItem.get(t.getName()) != null) {
            t.setNum(t.getNum() + buyItem.get(t.getName()).getNum());
        }
        buyItem.put(t.getName(), t);
        System.out.println(t.getName()+",num:" + buyItem.get(t.getName()).getNum());
    }

    public void deleThing(String name, int num) {
        thing t = buyItem.get(name);
        t.setNum(t.getNum() - num);
    }

    public thing getThing(String name) {
        thing t = buyItem.get(name);
        if (t == null) {
            t = new thing("", "", 0.0);
            t.setNum(0);
        }
        return t;
    }

    public double getSum() {
        Set<String> items = buyItem.keySet();
        double res = 0;
        for (String name : items) {
            res += thingUtil.getPrice(name) * buyItem.get(name).getNum();
        }
        return res;
    }

    public void dropNum(String name) {
        thing t = buyItem.get(name);
        if (t.getNum() < 2 || t == null)
            return;
        t.setNum(t.getNum() - 1);
        System.out.println(name + ":" + buyItem.get(name).getNum());
    }

    public void addNum(String name) {
        thing t = buyItem.get(name);
        if (t == null)
            return;
        t.setNum(t.getNum() + 1);
        System.out.println(name + ":" + buyItem.get(name).getNum());
    }
}
