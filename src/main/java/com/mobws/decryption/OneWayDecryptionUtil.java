package com.mobws.decryption;

import java.io.IOException;

import sun.misc.BASE64Decoder;

/**
 * 
 * @ClassName: OneWayDecryptionUtil 
 * @Description: one-way decryption algorithm 单向加密算法解密工具类 
 * 		单向加密算法包含 
 *		BASE64 严格地说，属于编码格式，而非加密算法 
 *		MD5(Message Digest algorithm 5，信息摘要算法)
 *		SHA(Secure Hash Algorithm，安全散列算法) 
 * 		HMAC(Hash Message Authentication Code，散列消息鉴别码)
 * @author liujn
 * @date 2018年1月12日 下午3:29:07 
 *
 */
public class OneWayDecryptionUtil {

	public byte[] decryptBASE64(String key){
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] decrptCoder = null;
		try {
			decrptCoder = decoder.decodeBuffer(key);
		} catch (IOException e) {
			System.out.println("BASE64解密失败!");
			e.printStackTrace();
		}
		return decrptCoder;
	}
	
}