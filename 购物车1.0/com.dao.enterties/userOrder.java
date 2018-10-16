package com.dao.enterties;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018/9/30.
 * 用户的订单类
 */
public class userOrder {
    private String userName, thingName;
    private int num;
    private String buyDate;
    private static SimpleDateFormat format =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static userOrder
    UserOrderFactory(String userName, String thingName, int num) {
        Date day = new Date();
        String date = format.format(day);
        userOrder order = new userOrder();
        order.setUserName(userName);
        order.setThingName(thingName);
        order.setNum(num);
        order.setBuyDate(date);
        return order;
    }

    public static boolean addOrder(String userName, String thingName, int num) {
        userOrder order = UserOrderFactory(userName, thingName, num);
        Statement stat = DBUtil.getStat();
        String sql = "INSERT INTO userOrder VALUES " +
                "(\"" + userName + "\",\"" + thingName + "\"," + num +
                ",STR_TO_DATE(\"" + order.getBuyDate() + "\",\"%Y-%m-%d %h:%i:%s\"));";

        try {
            int nums = stat.executeUpdate(sql);
            if (nums == 0) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private userOrder() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getThingName() {

        return thingName;
    }

    public void setThingName(String thingName) {
        this.thingName = thingName;
    }

    public int getNum() {

        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getBuyDate() {

        return buyDate;
    }

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }
}
