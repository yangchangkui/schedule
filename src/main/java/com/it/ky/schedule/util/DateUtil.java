package com.it.ky.schedule.util;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.util.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author: yangchangkui
 * @date: 2018-11-03 18:40
 */
public class DateUtil {

    /**
     * 根据模式获取时间
     * @param pattern
     * @return
     */
    public static String getCurrDate(String pattern){
        Assert.hasLength(pattern,"pattern is null");
        try {
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            String strDate = format.format(new Date());
            return strDate;
        }catch (Exception e){
            return null;
        }
    }


    /**
     * 根据模式获取时间
     * @param pattern
     * @return
     */
    public static String getDate(Date date ,String pattern){
        Assert.hasLength(pattern,"pattern is null");
        try {
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            String strDate = format.format(date);
            return strDate;
        }catch (Exception e){
            return null;
        }
    }


    /**
     * 传入当前年月日，获取指定天数的日期列表
     * @param strDate
     * @param day
     * @return
     */
    public static List<String> getDateList(String strDate,int day){
        List<String> dateList = new ArrayList<>();
        Date date = null;
        try {
            date = DateUtils.parseDate(strDate,"yyyy-MM-dd");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (int i = 0 ; i < day ; i ++){
            Date tempDate = DateUtils.addDays(date, i);
            dateList.add(getDate(tempDate,"yyyy-MM-dd"));
        }
        return dateList;
    }


    /**
     * 传入当前年月日，获取指定天数的日期列表
     * @param startDate
     * @param endDate
     * @return
     */
    public static List<String> getDateList(String startDate,String endDate){
        List<String> dateList = new ArrayList<>();
        Date sDate = null;
        Date eDate = null;
        try {
            sDate = DateUtils.parseDate(startDate,"yyyy-MM-dd");
            eDate = DateUtils.parseDate(endDate,"yyyy-MM-dd");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long dayTime = eDate.getTime() - sDate.getTime();
        int day = Math.toIntExact(dayTime / 1000 / 60 / 60/24);
        return getDateList(startDate,day);
    }

    public static void main(String[] args) {
        List<String> dateList = getDateList("2018-11-05", "2018-11-09");
        System.out.println(dateList);
    }


}
