package com.dao.enterties;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Administrator on 2018/9/30.
 * thing的工具类，用于查找数据库里的thing信息
 */
public class thingUtil {

    public static double getPrice(String name) {
        Statement stat = DBUtil.getStat();
        String sql = "SELECT price FROM thing WHERE name=\'" + name + "\';";

        ResultSet rs = null;

        try {
            rs = stat.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }

        try {
            if (rs.next()) {
                double d = (double) rs.getObject(1);
                System.out.println(d);
                return d;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }

        return 0;
    }

    public static thing getThing(String name) {
        Statement stat = DBUtil.getStat();
        String sql = "select* from thing where name=\'" + name + "\'";

        thing res = null;
        ResultSet rs = null;
        try {
            rs = stat.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        String thingName = "";
        String desc = "";
        double price = 0;
        int num = 0;

        try {
            if (rs.next()) {
                thingName = rs.getString(1);
                desc = rs.getString(2);
                price = rs.getDouble(3);
                num = rs.getInt(4);
            }
            res = new thing(desc, thingName, price);
            res.setNum(num);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return res;
    }

    public static String getDesc(String name) {
        Statement stat = DBUtil.getStat();
        String sql = "SELECT description FROM thing WHERE name=\'" + name + "\';";

        String desc = "";
        ResultSet rs = null;

        try {
            rs = stat.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return desc;
        }

        try {
            if (rs.next())
                return (String) rs.getObject(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return desc;
        }

        return desc;
    }

    public static int getNum(String name) {
        Statement stat = DBUtil.getStat();
        String sql = "SELECT num FROM thing WHERE name=\'" + name + "\';";

        ResultSet rs = null;

        try {
            rs = stat.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }

        try {
            if (rs.next())
                return (int) rs.getObject(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }

        return 0;
    }

}
