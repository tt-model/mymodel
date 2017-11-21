import com.application.v1.library.AesEncodeUtil;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.commons.codec.binary.Base64;
import org.junit.Ignore;
import org.junit.Test;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.SecureRandom;


/**
 * @author ttm
 * @data 2017/11/19
 */
@Ignore
public class AesTest {

    public String content = "xiaoming";

    public void aesTest() throws Exception {
        //随机生成 key
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        SecretKey secretKey = keyGenerator.generateKey();
        byte[] bytes = secretKey.getEncoded();

        //key 的转换
        Key key = new SecretKeySpec(bytes, "AES");

        //加密
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);  //加密模式初始化
        byte[] result = cipher.doFinal(content.getBytes("UTF-8"));
        String r1 = Base64.encodeBase64String(result);
        System.out.println("ttm | " + r1);

        //解密
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] result2 = cipher.doFinal(Base64.decodeBase64(r1));
        System.out.println("ttm | " + new String(result2, "UTF-8"));
    }

    public void specifiedStrGenrateKey() throws Exception {
        //指定字段生成密钥
        String password = "tangtaiming";
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128, new SecureRandom(password.getBytes("UTF-8")));

//        SecretKeySpec secretKeySpec = new SecretKeySpec("xiaoming".getBytes("UTF-8"), "AES");
//        SecretKey secretKey = keyGenerator.generateKey();
//        byte[] bytes = secretKey.getEncoded();

        //获取 key
        Key key = keyGenerator.generateKey();

        //加密
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] ciperBytes = cipher.doFinal("xiaoming".getBytes("UTF-8"));
        String hexStr = byteToHexString(Base64.encodeBase64(ciperBytes));
        System.out.println("encrypt : " + hexStr);

        //解密 密钥
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptBytes = cipher.doFinal(Base64.decodeBase64("vu224ZsiCupIC43muXSqmw=="));
        System.out.println("decrypt : " + new String(decryptBytes));
    }

    public void loginTest() throws Exception {
        String password = "tangtaiming+";
        String pe = "NkyYU7i7JA+kRTgcmYXWAg==";
        //注册进行 密码加密
        String encryptionStr = AesEncodeUtil.encryption(password);
        System.out.println("encryption : " + encryptionStr);

        //获取 配置获取 账号加密密码 进行解密
        String decryptStr = AesEncodeUtil.decrypt(pe);
        System.out.println("ttm | " + decryptStr);
    }

    /**
     *
     * byte数组转化为16进制字符串
     * @param bytes
     * @return
     */
    public static String byteToHexString(byte[] bytes){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            String strHex=Integer.toHexString(bytes[i]);
            if(strHex.length() > 3){
                sb.append(strHex.substring(6));
            } else {
                if(strHex.length() < 2){
                    sb.append("0" + strHex);
                } else {
                    sb.append(strHex);
                }
            }
        }
        return  sb.toString();
    }

}
