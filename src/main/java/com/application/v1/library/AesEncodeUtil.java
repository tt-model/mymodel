package com.application.v1.library;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.SecureRandom;

/**
 * 加密工具
 * @author ttm
 * @data 2017/11/19
 */
public class AesEncodeUtil {

    public static final String INSTANCE_STR = "AES";

    /**
     * 默认加密使用 key
     */
    public static final String KEY_CODE = "ttbride";

    /**
     * 默认编码格式
     */
    public static final String DEFAULT_CODING = "UTF-8";

    /**
     * 加密
     * @param content       待编码的字符串
     * @return              编码后的base 64 code
     */
    public static String encryption(String content) throws Exception {
        Key key = fetchKey();
        //进行数据加密
        Cipher cipher = Cipher.getInstance(INSTANCE_STR);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptionByte = cipher.doFinal(content.getBytes(DEFAULT_CODING));
        return Base64.encodeBase64String(encryptionByte);
    }

    /**
     * 解密
     * @param content
     * @return
     * @throws Exception
     */
    public static String decrypt(String content) throws Exception {
        Key key = fetchKey();
        //进行数据加密
        Cipher cipher = Cipher.getInstance(INSTANCE_STR);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] encryptionByte = cipher.doFinal(Base64.decodeBase64(content));
        return new String(encryptionByte);
    }

    /**
     * 获取加密KEY
     * @return
     * @throws Exception
     */
    private static Key fetchKey() throws Exception {
        //获取加密key
        KeyGenerator keyGenerator = KeyGenerator.getInstance(INSTANCE_STR);
        keyGenerator.init(128, new SecureRandom(KEY_CODE.getBytes(DEFAULT_CODING)));
        Key key = keyGenerator.generateKey();
        return key;
    }

}
