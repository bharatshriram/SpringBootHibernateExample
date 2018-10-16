/**
 * 
 */
package com.hanbit.SpringBootHibernateExample.service;

import java.sql.SQLException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import com.hanbit.SpringBootHibernateExample.Response.ResponseVO;
import com.hanbit.SpringBootHibernateExample.dao.LoginDAO;
import com.hanbit.SpringBootHibernateExample.expections.BusinessException;
import com.hanbit.SpringBootHibernateExample.model.LoginVO;

/**
 * @author Bharat Kumar
 *
 */
@Service
public class LoginBOImpl implements LoginBO {
	
	@Autowired
	LoginDAO logindao;
	
	@Transactional
	public ResponseVO CheckLogin(LoginVO loginvo) throws ClassNotFoundException, BusinessException, SQLException{
		ResponseVO responsevo = new ResponseVO();
		System.out.println("===>"+loginvo);
		if (loginvo.getUserName().isEmpty() || loginvo.getPassword().isEmpty()) {

			throw new BusinessException("ENTER USERNAME AND PASSWORD");
		}
		responsevo=logindao.LoginCheckDAO(loginvo) ;
		return responsevo;
	}

	@Override
	public ResponseVO forgotpassword(String userid) {
		// TODO Auto-generated method stub
		return null;
	}
}
