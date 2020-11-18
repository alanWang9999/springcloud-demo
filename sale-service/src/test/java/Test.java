import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.MD5;
import cn.hutool.crypto.symmetric.AES;

/**
 * @ClassName Test
 * @Author alan.wang   QQ:3103484396
 * @Description TODO
 */
public class Test {
    public static void main(String[] args) {
        //MD5不可逆加密
//        String str = new MD5().digestHex ("www123123");
//        System.out.println(str);

        //可逆的，对称性加密
        /** 密钥 */
        byte [] key = {2,5,9,1,5,10,2,1,5,10,6,9,10,5,4,12};
        /** 通过密钥创建AES对象 */
        AES aes = SecureUtil.aes(key);
        /** 要被加密的原始数据 */
        String content = "这里是9021";
        /** 加密 */
        byte [] bs = aes.encrypt(content);
        /** 通过Base64把字节数组转换成String */
        String secrityStr = Base64.encode(bs);
        System.out.println("加密后:" + secrityStr);
        /** 通过Base64把String转换成字节数组 */
        byte [] bs2 = Base64.decode(secrityStr);
        /** 把字节数组进行解密,就可以拿到原始信息 */
        System.out.println("解密:" + aes.decryptStr(bs2));
    }
}
