package com.springrest.springrest.services;
import java.sql.*;
public class userDetailsClass implements UserDetails {
  public boolean validateUser(String UserName) throws SQLException {	  
   /** 
    * DataBase Credentials to login into table , Another way of logging into DB
    */  
    final String URL = "jdbc:mysql://localhost:3306/stocks";
    final String userid = "anil";
    final String Password = "anilChow@6";   
    /**
     * select query which is used to check user is valid or not
     */   
    String query = "SELECT * FROM USERS WHERE USERID = '" + UserName + "';"; 
    try (Connection conn = DriverManager.getConnection(URL, userid, Password); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query);)
    {
      if (rs.next())
      {
        return true;
      }
    }
    catch (Exception e) {}
    return false;
  }
  /**
   * validateUser() this method will take user id as input and it is declaring with SQLExceptions as it is dealing with DB Connection
   * the motive of this method is to check the user is maintained in the DB or not
   * if the user is maintained then it will return true else it will return false
   * 
   */
  
}