package com.mobws.utils;

import java.util.UUID;

/**
 * 
 * @ClassName:     KeyProvider.java
 * @Description:   获取主键类 
 * 
 * @author         LJN
 * @version        V1.0  
 * @Date           2016-3-25 下午1:09:29
 */
public class KeyProvider {

	/**
	 * 获取主键
	 * @return
	 */
	public static String getPrimaryKey(){
		return UUID.randomUUID().toString();
	}
	
}
