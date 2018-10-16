/**
 * 
 */
package com.hanbit.SpringBootHibernateExample.service;

import java.sql.SQLException;

import com.hanbit.SpringBootHibernateExample.Response.ResponseVO;
import com.hanbit.SpringBootHibernateExample.expections.BusinessException;
import com.hanbit.SpringBootHibernateExample.model.LoginVO;

/**
 * @author Bharat Kumar
 *
 */


public interface LoginBO {
	
	public ResponseVO CheckLogin(LoginVO loginvo) throws ClassNotFoundException, BusinessException, SQLException;

	public ResponseVO forgotpassword(String userid);

	
}
