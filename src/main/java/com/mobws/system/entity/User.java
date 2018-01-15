package com.mobws.system.entity;

import java.io.Serializable;

/**
 * 
 * @ClassName: User 
 * @Description: 用户表对应实体 org_user
 * @author liujn liujn@mobws.com
 * @date 2016年5月17日 下午2:49:44 
 *
 */				
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String userId;
	private String username;
	private String loginname;
	private String password;
	private String eamil;
	private String sex;
	private String birthday;
	private String intime;
	private String nativeplace;
	private String recordschool;
	private String createtime;

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the loginname
	 */
	public String getLoginname() {
		return loginname;
	}

	/**
	 * @param loginname
	 *            the loginname to set
	 */
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the eamil
	 */
	public String getEamil() {
		return eamil;
	}

	/**
	 * @param eamil
	 *            the eamil to set
	 */
	public void setEamil(String eamil) {
		this.eamil = eamil;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex
	 *            the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the birthday
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday
	 *            the birthday to set
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return the intime
	 */
	public String getIntime() {
		return intime;
	}

	/**
	 * @param intime
	 *            the intime to set
	 */
	public void setIntime(String intime) {
		this.intime = intime;
	}

	/**
	 * @return the nativeplace
	 */
	public String getNativeplace() {
		return nativeplace;
	}

	/**
	 * @param nativeplace
	 *            the nativeplace to set
	 */
	public void setNativeplace(String nativeplace) {
		this.nativeplace = nativeplace;
	}

	/**
	 * @return the recordschool
	 */
	public String getRecordschool() {
		return recordschool;
	}

	/**
	 * @param recordschool
	 *            the recordschool to set
	 */
	public void setRecordschool(String recordschool) {
		this.recordschool = recordschool;
	}

	/**
	 * @return the createtime
	 */
	public String getCreatetime() {
		return createtime;
	}

	/**
	 * @param createtime
	 *            the createtime to set
	 */
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username
				+ ", loginname=" + loginname + ", password=" + password
				+ ", eamil=" + eamil + ", sex=" + sex + ", birthday="
				+ birthday + ", intime=" + intime + ", nativeplace="
				+ nativeplace + ", recordschool=" + recordschool
				+ ", createtime=" + createtime + "]";
	}

}
