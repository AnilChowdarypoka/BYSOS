package com.springrest.springrest.services;
import java.sql.SQLException;

public interface UserDetails {
	
	/**
	 * This interface is used to check the user entered is valid or not
	 * @param UserName
	 * @return
	 * @throws SQLException
	 */
	
	public  boolean validateUser (String UserName) throws SQLException;
}
