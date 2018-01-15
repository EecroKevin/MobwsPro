
package com.mobws.test.cryption;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

import com.mobws.decryption.OneWayDecryptionUtil;
import com.mobws.encryption.OneWayEncryptionUtil;

/**
 * 
 * @ClassName: EncryptionAndDecryptionTest 
 * @Description: 单向加密算法测试 
 * @author liujn
 * @date 2018年1月15日 下午4:13:38 
 *
 */
public class EncryptionAndDecryptionTest {

	@Test
	public void EnAndDeTest() {
		String coder = "A 600 eq, Israel produced big BOMB";
		byte[] coderByte = coder.getBytes();
		System.out.println("原文: [ " + coder + " ]");
		
		OneWayEncryptionUtil encry = new OneWayEncryptionUtil();
		OneWayDecryptionUtil decry = new OneWayDecryptionUtil();
		
		//BASE64加密解密
		String encryCoder = encry.encryptBASE64(coderByte);
		System.out.println("BASE64加密密文: [ " + encryCoder.trim() + " ]");

		byte[] decryCoderByteArray = decry.decryptBASE64(encryCoder);
		String decryCoder = new String(decryCoderByteArray);
		System.out.println("BASE64解密后: [ " + decryCoder.trim() + " ]");

		// 验证BASE64加密解密一致性  
		//assertEquals(coderByte, decryCoderByteArray);

		//MD5
		byte[] md5Encrypt = encry.encryptMD5(coderByte);
		BigInteger md5 = new BigInteger(md5Encrypt);
		System.out.println("MD5加密后：[ " + md5.toString(16) + "]");
		// 验证MD5对于同一内容加密是否一致  
		assertArrayEquals(encry.encryptMD5(coderByte), encry.encryptMD5(coderByte));

		byte[] shaEncrpt = encry.encryptSHA(coderByte);
		BigInteger sha = new BigInteger(shaEncrpt);
		System.out.println("SHA加密后: ["+ sha.toString(16) +"]");
		// 验证SHA对于同一内容加密是否一致  
		assertArrayEquals(encry.encryptSHA(coderByte), encry.encryptSHA(coderByte));

		String macKey = encry.initMacKey();
		byte[] macEncry = encry.encryptHMAC(coderByte, macKey);
		BigInteger mac = new BigInteger(macEncry);
		System.out.println("MACKEY: ["+ macKey.trim() +"]");
		System.out.println("MAC加密后：["+ mac.toString(16) +"]");
	}

}