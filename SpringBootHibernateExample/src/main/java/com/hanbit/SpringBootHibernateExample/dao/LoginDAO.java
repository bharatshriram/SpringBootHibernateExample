/**
 * 
 */
package com.hanbit.SpringBootHibernateExample.dao;

import java.sql.SQLException;

import com.hanbit.SpringBootHibernateExample.Response.ResponseVO;
import com.hanbit.SpringBootHibernateExample.expections.BusinessException;
import com.hanbit.SpringBootHibernateExample.model.LoginVO;

/**
 * @author USER
 *
 */
public interface LoginDAO {

	public ResponseVO LoginCheckDAO(LoginVO loginvo) throws ClassNotFoundException, SQLException, BusinessException;
	
	
	
}
