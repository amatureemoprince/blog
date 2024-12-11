package com.lj.blog.common.utils;
import com.alibaba.druid.filter.config.ConfigTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @ClassName DataEncryptUtil
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/9 20:51
 * @Version JDK 17
 */
public class DataEncryptUtil {
    private static final Logger log = LoggerFactory.getLogger(DataEncryptUtil.class);
    // 密钥对
    private static String publicKey;
    private static String privateKey;
    // 密钥长度
    private static final int KEY_SIZE = 512;
    static {
        try {
            initKeyPair();
        } catch (Exception e) {
            log.error("初始化密钥对失败", e);
            throw new RuntimeException("初始化密钥对失败", e);
        }
    }
    /**
     * 初始化密钥对
     */
    private static void initKeyPair() throws Exception {
        String[] keyPair = ConfigTools.genKeyPair(KEY_SIZE);
        privateKey = keyPair[0];
        publicKey = keyPair[1];
        log.info("密钥对初始化成功");
        // 不建议在生产环境打印密钥
        if (log.isDebugEnabled()) {
            log.debug("privateKey: {}", privateKey);
            log.debug("publicKey: {}", publicKey);
        }
    }
    /**
     * 加密
     * @param plainText 明文
     * @return 密文
     */
    public static String encrypt(String plainText) {
        try {
            String encrypt = ConfigTools.encrypt(privateKey, plainText);
            log.debug("加密成功: {}", encrypt);
            return encrypt;
        } catch (Exception e) {
            log.error("加密失败: {}", plainText, e);
            throw new RuntimeException("加密失败", e);
        }
    }
    /**
     * 解密
     * @param encryptText 密文
     * @return 明文
     */
    public static String decrypt(String encryptText) {
        try {
            String decrypt = ConfigTools.decrypt(publicKey, encryptText);
            log.debug("解密成功: {}", decrypt);
            return decrypt;
        } catch (Exception e) {
            log.error("解密失败: {}", encryptText, e);
            throw new RuntimeException("解密失败", e);
        }
    }
    /**
     * 生成配置文件所需的加密密码
     * @param args 参数
     */
    public static void main(String[] args) {
        try {
            String password = "200481lj";
            String encrypted = encrypt(password);
            System.out.println("加密后的密码: " + encrypted);
            System.out.println("publicKey: " + publicKey);
            // 验证解密
            String decrypted = decrypt(encrypted);
            assert password.equals(decrypted) : "加解密验证失败";
            // 生成配置
            System.out.println("\n=== 配置示例 ===");
            System.out.println("spring.datasource.password=" + encrypted);
            System.out.println("spring.datasource.publicKey=" + publicKey);
        } catch (Exception e) {
            log.error("生成加密配置失败", e);
        }
    }
}
