/**
 * 
 */
package com.hanbit.SpringBootHibernateExample.Controller;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.hanbit.SpringBootHibernateExample.Response.ResponseVO;
import com.hanbit.SpringBootHibernateExample.constants.ExtraConstants;
import com.hanbit.SpringBootHibernateExample.expections.BusinessException;
import com.hanbit.SpringBootHibernateExample.model.LoginVO;
import com.hanbit.SpringBootHibernateExample.service.LoginBO;
import com.hanbit.SpringBootHibernateExample.utils.Encryptor;

/**
 * @author Bharat Kumar
 *
 */
@RestController
@RequestMapping(value ="/SpringBootHibernateExample")
public class LoginController {
	@Autowired
	private LoginBO loginbo;
	
	Gson gson = new Gson();

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public
	ResponseVO validateUser(@RequestBody LoginVO loginvo)
			throws ClassNotFoundException, BusinessException, SQLException {

		ResponseVO responsevo = new ResponseVO();
		
		System.out.println("===>"+loginvo.getPassword());

		loginvo.setPassword(Encryptor.encrypt(ExtraConstants.key1,
				ExtraConstants.key2, loginvo.getPassword()));

		try {
			responsevo = loginbo.CheckLogin(loginvo);
		} catch (BusinessException e) {
			String message = e.getMessage();
			responsevo.setErrorMessage(message);
		}
		return responsevo;
	}
	
	@RequestMapping(value = "/forgotpassword/{userid}", method = RequestMethod.POST, produces = "application/json")
	public
	ResponseVO forgotpassword(@PathVariable("userid") String userid)
			throws ClassNotFoundException, BusinessException, SQLException {

		ResponseVO responsevo = new ResponseVO();

		//try {
			responsevo = loginbo.forgotpassword(userid);
			responsevo.setResult("Success");
		//}
		/* catch (BusinessException e) {
				String message = e.getMessage();
				responsevo.setErrorMessage(message);
			}*/
		/*catch (MessagingException e) {
			String message = e.getMessage();
			responsevo.setErrorMessage(message);
		}*/
		return responsevo;
	}
	
	
	


}
