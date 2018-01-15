package com.mobws.encryption;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.MessageDigestSpi;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.mobws.decryption.OneWayDecryptionUtil;

import sun.misc.BASE64Encoder;

/**
 * @ClassName: OneWayEncryptionUtil
 * @Description: one-way encryption algorithm 单向加密算法工具类 
 * 		单向加密算法包含 
 *		BASE64 严格地说，属于编码格式，而非加密算法 
 *		MD5(Message Digest algorithm 5，信息摘要算法)
 *		SHA(Secure Hash Algorithm，安全散列算法) 
 * 		HMAC(Hash Message Authentication Code，散列消息鉴别码)
 * @author liujn
 * @date 2018年1月12日 下午3:16:49
 */
public class OneWayEncryptionUtil {

	public static final String KEY_MD5 = "MD5";
	public static final String KEY_SHA = "SHA";
	public static final String KEY_MAC = "HmacMD5";
	
	/**
	 * 
	 * @Title: encryptBASE64
	 * @author liujn   
	 * @date 2018年1月12日 下午3:25:29 
	 * @Description: BASE64加密 BASE加密后产生的字节位数是8的倍数，如果不够位数以=符号填充
	 * @param key
	 * @return String
	 */
	public String encryptBASE64(byte[] key){
		BASE64Encoder encoder = new BASE64Encoder();
		String encryptCoder = encoder.encodeBuffer(key);
		return encryptCoder;
	}
	
	/**
	 * 
	 * @Title: encryptMD5
	 * @author liujn   
	 * @date 2018年1月12日 下午4:46:22 
	 * @Description: message-digest algorithm 5 （信息-摘要算法）
	 * @param data
	 * @return byte[]
	 */
	public byte[] encryptMD5(byte[] data){
		byte[] encryptCoder = null;
		try {
			//实例化MessageDigest, 创建MD5散列算法
			MessageDigest md5 = MessageDigest.getInstance(KEY_MD5);
			//传送需要处理的数据
			md5.update(data);
			//生成散列码
			encryptCoder = md5.digest();
		} catch (NoSuchAlgorithmException e) {
			System.out.println("实例化 MessageDigest 失败!");
			e.printStackTrace();
		}
		return encryptCoder;
	}
	
	/**
	 * 
	 * @Title: encryptSHA
	 * @author liujn   
	 * @date 2018年1月12日 下午4:48:43 
	 * @Description: SHA(Secure Hash Algorithm，安全散列算法）
	 * @param data
	 * @return byte[]
	 */
	public byte[] encryptSHA(byte[] data){
		byte[] encryptCoder = null;
		try {
			//实例化MessageDigest, 创建SHA散列算法
			MessageDigest sha = MessageDigest.getInstance(KEY_SHA);
			//传送需要处理的数据
			sha.update(data);
			//生成散列码
			encryptCoder = sha.digest();
		} catch (NoSuchAlgorithmException e) {
			System.out.println("实例化 MessageDigest 失败!");
			e.printStackTrace();
		}
		return encryptCoder;
	}
	
	/**
	 * 初始化HMAC秘钥
	 */
	public String initMacKey(){
		String macKey = null;
		try {
			//初始化
			KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_MAC);
			//生成一个秘钥
			SecretKey secretKey = keyGenerator.generateKey();
			//对秘钥进行BASE64编码
			macKey = this.encryptBASE64(secretKey.getEncoded());
		} catch (NoSuchAlgorithmException e) {
			System.out.println("实例化 KeyGenerator 失败!");
			e.printStackTrace();
		}
		return macKey;
	}
	
	/**
	 * 
	 * @Title: encryptHMAC
	 * @author liujn   
	 * @date 2018年1月12日 下午5:37:39 
	 * @Description:  HMAC(Hash Message Authentication Code，散列消息鉴别码，基于密钥的Hash算法的认证协议。
	 * 消息鉴别码实现鉴别的原理是，用公开函数和密钥产生一个固定长度的值作为认证标识，用这个标识鉴别消息的完整性。
	 * 使用一个密钥生成一个固定大小的小数据块，即MAC，并将其加入到消息中，然后传输。
	 * 接收方利用与发送方共享的密钥进行鉴别认证等。
	 * HmacMD5	128	JAVA6实现
	 * HmacSHA1	160	JAVA6实现
	 * HmacSHA256	256	JAVA6实现
	 * HmacSHA384	384	JAVA6实现
	 * HmacSHA512	512	JAVA6实现
	 * HmacMD2	128	BouncyCastle实现
	 * HmacMD4	128	BouncyCastle实现
	 * HmacSHA224	224	BouncyCastle实现
	 * @param date
	 * @param key
	 * @return byte[]
	 */
	public byte[] encryptHMAC(byte[] date, String key){
		byte[] encryptCoder = null;
		//对秘钥进行解码
		OneWayDecryptionUtil decry = new OneWayDecryptionUtil();
		byte[] decryCoderByteArray = decry.decryptBASE64(key);
		//初始化加密算法
		SecretKeySpec secretKeySpec = new SecretKeySpec(decryCoderByteArray, KEY_MAC);
		Mac mac;
		try {
			//实例化Mac
			mac = Mac.getInstance(secretKeySpec.getAlgorithm());
			//初始化Mac
			mac.init(secretKeySpec);
			//执行消息摘要处理 
			encryptCoder = mac.doFinal(date);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return encryptCoder;
	}
	
}