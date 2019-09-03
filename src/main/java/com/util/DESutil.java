package com.util;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class DESutil {
    //指定加密算法为DESede
    private static String ALGORITHM = "DESede";
    //指定密钥存放文件
    private static String KEYFile = "KeyFile";
    private static final Logger log = LogManager.getLogger(DESutil.class);

    //生成密钥
    private static void generateKey() throws Exception {
        //可信任的随机数源
        SecureRandom sr = new SecureRandom();
        //为DES算法创建一个KeyGenerator对象
        KeyGenerator kg = KeyGenerator.getInstance(ALGORITHM);
        //利用上面的随机数源初始化这个KeyGenerator对象
        kg.init(sr);
        //生成密钥
        SecretKey key = kg.generateKey();
        //用对象流将生成的密钥写入文件
        ObjectOutputStream oos = new
                ObjectOutputStream(new FileOutputStream(KEYFile));
        oos.writeObject(key);
        //清空缓存,关闭文件输出流
        oos.close();
    }

    //加密方法
    public static String encrypt(String source) throws Exception {
        generateKey();
        //读取文件中的SecretKey对象
        ObjectInputStream ois = new
                ObjectInputStream(new FileInputStream(KEYFile));
        SecretKey key = (SecretKey) ois.readObject();
        //得到Cipher对象来实现对源数据的DES加密
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE,key);
        byte[] b = source.getBytes();
        //执行加密操作
        byte[] b1 = cipher.doFinal(b);
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(b1);
    }

    //解密密钥 cryptograph 密文
    public static String decrypt(String cryptograph) throws Exception{
        ObjectInputStream ois = new
                ObjectInputStream(new FileInputStream(KEYFile));
        SecretKey key = (SecretKey) ois.readObject();
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        //DECRYPT_MODE 解密模式
        cipher.init(Cipher.DECRYPT_MODE,key);
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] b1 = decoder.decodeBuffer(cryptograph);
        byte[] b = cipher.doFinal(b1);
        return new String(b);
    }

    //测试
    public static void main(String[] args) throws Exception{
        String source = "123456";
        String crptograph = encrypt(source);
        log.error("原信息 : "+source);
        log.error("加密 : "+crptograph);

        String target = decrypt(crptograph);
        log.error("解密 : "+target);

    }
}
