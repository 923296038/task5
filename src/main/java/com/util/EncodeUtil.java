package com.util;

import com.serviceImpl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class EncodeUtil {
    private static final Logger log = LogManager.getLogger(EncodeUtil.class);
    public String MD5Util(String data){
        //获得java提供的信息摘要算法加密功能类的一个实例
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            log.error(e.toString());
            e.printStackTrace();
        }
        //将获取到的string转换成byte数组
        char[] chars = data.toCharArray();
        byte[] bytes = new byte[chars.length];
        for (int i = 0;i<chars.length;i++){
            bytes[i] = (byte) chars[i];
        }
        //获取MD5计算后的byte值
        byte[] md5byte = md5.digest(bytes);
        //将获取到的byte值转回string
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0;i<md5byte.length;i++){
            int val = ((int)md5byte[i]) & 0xff;
            if (val < 16){
                stringBuffer.append("0");
            }else {
                stringBuffer.append(Integer.toHexString(val));
            }
        }
        return stringBuffer.toString();
    }
    //生成随机字符串
    public String getRandomString(int length){
        String base = "qwertyuiopasdfghjklzxcvbnmQWER" +
                "TYUIOPASDFGHJKLZXCVBNM" +
                "1234567890";
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i=0;i<length;i++){
            int number = random.nextInt(base.length());
            stringBuffer.append(base.charAt(number));
        }
        return stringBuffer.toString();
    }

    //测试主函数
    public static void main(String args[]){
        EncodeUtil util = new EncodeUtil();
        String s = new String("123465Wq");
        String s1= new String("1234567");
        String s2= new String("123456");
        log.error("123456 > "+util.MD5Util(s));
        log.error("1234567 > "+util.MD5Util(s1));
        log.error("123457 > "+util.MD5Util(s2));
        log.error(util.getRandomString(10));
        log.error(util.getRandomString(10));
        log.error(util.getRandomString(10));
    }
}
