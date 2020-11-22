package com.msr.util;


import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * 字符串转日期 日期 转换器
 *  カスタム タイム コンバーター 自定义时间转换器
 *  文字列形式の日付を日付形式に変換する
 *  1. Converter インターフェイスを実装する  实现接口
 */
public class StringToDateConverter implements Converter<String, Date>  {

    @Override
    public Date convert(String s) {
        if (s == null) {
            throw new RuntimeException("日付を入力してください");
        }
        //  文字列を日付に変換する  String --> Date
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM/dd");
        DateFormat dateFormat2 = new SimpleDateFormat("yyyyMMdd");

        try {
            if (s.contains("-")) {
                return dateFormat.parse(s);
            }
            if (s.contains("/")) {
                return dateFormat1.parse(s);
            }
//            // 整数かどうかを判断する
//            if (s.length()==8&&isInteger(s)) {
//
//            return dateFormat2.parse(s);
//            }
            else {
                throw new RuntimeException("日付のフォーマットが間違った、再入力");
            }

        } catch (ParseException e) {
            throw new RuntimeException("日付、フォーマット変換エラー、再入力"+e.getMessage());
        }
    }


    /**
     * 判断是否为整数
     * @param s
     * @return 是整数返回true,否则返回false
     */
    public  boolean isInteger(String s) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(s).matches();
    }
}
