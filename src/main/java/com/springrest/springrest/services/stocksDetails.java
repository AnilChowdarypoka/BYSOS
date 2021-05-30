package com.springrest.springrest.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springrest.springrest.Db.Dao;
import com.springrest.springrest.stock.Stock;
import java.util.List;

@Service   
/** 
 * Defining this is the service class
 * */

public class stocksDetails implements stockService {
	
  @Autowired
  
  private Dao dao;  // Dao object used to connect with JPA
    
  public List < Stock > getStocks()  
  {
    return dao.findAll();
  }
  
  /**
   * getStocks() will take no parameters and it is used to return all the stock items from the stock table 
   * it can be achieved by findAll() method.
   * this method will return all the stocks in the form of list
   */
  
  public Stock getStockByCategoryId(long CategoryId) 
  {
    Stock tempstock = null;
    List < Stock > str = dao.findAll();
    for (Stock s: str) {
      if (s.getCategoryId() == CategoryId) 
      { 
        System.out.println("Valid Category Id , displaying the Data");
        return s;
        }}
    System.out.println("Invalid Category Id , No Data to be displayed");
    return tempstock;
  }
  
  /**
   * getStockByCategoryId() this method will take category id as it's parameter and it is used to find stock item by it's categoryid
   * If there is any entries related to that category id then  it will return the stock data  , else it will Null
   * to check for our required stock item , i am iterating all the stock items , once we got out required item then program will terminate 
   * it will return stock item, if no matches then it will return Null
   */

  @Override
  public Stock addStock(Stock stock) 
  {
    dao.save(stock);
    return stock;
  }
  
  /**
   * addStock() will take stock object as it's parameters and it is used to insert the stock item into the stock table 
   * we can insert an item into  a table by save() method.
   * this method will return inserted stocks item to get it checked by user.
   */
  
  
  @Override
  public Stock getStockByCategoryIdByValidatingUser(long CategoryId, String id)
  {
    userDetailsClass Userdetails = new userDetailsClass(); 
    boolean flag = false;
    Stock tempstock = null;
    try {
      flag = Userdetails.validateUser(id); // calling method to check user is valid or not
    } catch (Exception e) {}
    if (flag) {
      System.out.println("Valid user...Checking for Stock Data");
      tempstock = getStockByCategoryId(CategoryId);  // calling method to get Stock By CategoryId 
    } else { 	
      System.out.println("Invalid User.., Please login with valid user credentials");
    }
    return tempstock;
  }
  
  /**
   * getStockByCategoryIdByValidatingUser() this method will take category id , userid as it's parameter 
   * This method is used to validate the user , if user is invalid then program will return Null else it will check for the stock item.
   * if the user is invalid then it program will return NULL 
   * Once User got validated , If there is any entries related to that category id then it will return the stock data,else it will Null
   * to check for our required stock item , i am iterating all the stock items , once we got out required item then program will terminate 
   * it will return stock item, if no matches then it will return Null
   */
  
  
  @Override
  public void updateStocks(Stock stock)
  {
    dao.save(stock);
  }  
  /**
   * updateStocks() will take stock object as it's parameters and it is used to update the stock item in the stock table 
   * we can update an item in the table by save() method , if there are no item related to primary key then it will insert into table.
   * this method will return updated stock item to get it checked by user.
   */
}