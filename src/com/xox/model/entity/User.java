/*
*  User.java
*	@author 创建人
*	@data 创建时间
*
*
*/
package com.xox.model.entity;

import java.util.Date;

/**
 *XOX_USER
 */
public class User {
    private static final long serialVersionUID = -15322212927045L;
    
    
    protected Long id;
	  /**
    * 
    */
    protected Date birthday;	
      /**
    * 
    */
    protected Long deleted;	
      /**
    * 
    */
    protected String name;	
      /**
    * 
    */
    protected String nickname;	
      /**
    * 
    */
    protected String password;	
      /**
    * 
    */
    protected Long role;	
      /**
    * 
    */
    protected Long sex;	
    	
      /**
     *	字段描述 数据可阻断名
	 * @author zhengnl
	 * @data 创建时间
	 * @return ****
	 */  
    public Date getBirthday() {
        return birthday;
	}
	/**
	 * 字段描述
	 * @author zhengnl
	 * @data 创建时间
	 * @return void
	 */ 	
	public void setBirthday(Date birthday) {
		this.birthday=birthday;
	}
      /**
     *	字段描述 数据可阻断名
	 * @author zhengnl
	 * @data 创建时间
	 * @return ****
	 */  
    public Long getDeleted() {
        return deleted;
	}
	/**
	 * 字段描述
	 * @author zhengnl
	 * @data 创建时间
	 * @return void
	 */ 	
	public void setDeleted(Long deleted) {
		this.deleted=deleted;
	}
      /**
     *	字段描述 数据可阻断名
	 * @author zhengnl
	 * @data 创建时间
	 * @return ****
	 */  
    public String getName() {
        return name;
	}
	/**
	 * 字段描述
	 * @author zhengnl
	 * @data 创建时间
	 * @return void
	 */ 	
	public void setName(String name) {
		this.name=name;
	}
      /**
     *	字段描述 数据可阻断名
	 * @author zhengnl
	 * @data 创建时间
	 * @return ****
	 */  
    public String getNickname() {
        return nickname;
	}
	/**
	 * 字段描述
	 * @author zhengnl
	 * @data 创建时间
	 * @return void
	 */ 	
	public void setNickname(String nickname) {
		this.nickname=nickname;
	}
      /**
     *	字段描述 数据可阻断名
	 * @author zhengnl
	 * @data 创建时间
	 * @return ****
	 */  
    public String getPassword() {
        return password;
	}
	/**
	 * 字段描述
	 * @author zhengnl
	 * @data 创建时间
	 * @return void
	 */ 	
	public void setPassword(String password) {
		this.password=password;
	}
      /**
     *	字段描述 数据可阻断名
	 * @author zhengnl
	 * @data 创建时间
	 * @return ****
	 */  
    public Long getRole() {
        return role;
	}
	/**
	 * 字段描述
	 * @author zhengnl
	 * @data 创建时间
	 * @return void
	 */ 	
	public void setRole(Long role) {
		this.role=role;
	}
      /**
     *	字段描述 数据可阻断名
	 * @author zhengnl
	 * @data 创建时间
	 * @return ****
	 */  
    public Long getSex() {
        return sex;
	}
	/**
	 * 字段描述
	 * @author zhengnl
	 * @data 创建时间
	 * @return void
	 */ 	
	public void setSex(Long sex) {
		this.sex=sex;
	}
      @Override
	public String toString() {
		StringBuffer rs = new StringBuffer();
		rs.append(getClass().getName());
		rs.append("\r\n");
				rs.append("birthday");
		rs.append(":");
		rs.append(getBirthday());
		rs.append("\r\n");
				rs.append("is_deleted");
		rs.append(":");
		rs.append(getDeleted());
		rs.append("\r\n");
				rs.append("name");
		rs.append(":");
		rs.append(getName());
		rs.append("\r\n");
				rs.append("nickname");
		rs.append(":");
		rs.append(getNickname());
		rs.append("\r\n");
				rs.append("password");
		rs.append(":");
		rs.append(getPassword());
		rs.append("\r\n");
				rs.append("role");
		rs.append(":");
		rs.append(getRole());
		rs.append("\r\n");
				rs.append("sex");
		rs.append(":");
		rs.append(getSex());
		rs.append("\r\n");
				rs.append("\r\n");
		return rs.toString();
	}

}