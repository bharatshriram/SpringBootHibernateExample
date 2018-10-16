/**
 * 
 */
package com.hanbit.SpringBootHibernateExample.Response;

/**
 * @author Bharat Kumar
 *
 */
public class ResponseVO {
	
	
	private String result;
	private int roleId;
	private String message;
	private String errorMessage;
	
	
	
	

	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	
	
	

}
