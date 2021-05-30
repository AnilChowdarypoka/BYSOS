package com.springrest.springrest.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springrest.springrest.services.stockService;
import com.springrest.springrest.stock.Stock;
import java.sql.SQLException;
import java.util.*;
@RestController  // Representational State Transfer used to write Rest API's
public class myController {
  @Autowired  // For creating objects by it's own
  
  private stockService stockservice; 
  
  /**
   * interface and object where Service was defined.
   */
  
  @GetMapping("/home")  
  
  public String home()     
  {
    return "Welcome to BYSOS";
  }
  
  @GetMapping(path = "/stocks/{id}") 
  public Stock getStockByCategoryId(@PathVariable String id) 
  {
    return this.stockservice.getStockByCategoryId(Long.parseLong(id)); 
  }
  
 /**
  * @GetMapping is used to retrive the data from dataBase  
  * path = localhost:8080/"/stocks/{id} ,  method : GET
  *  stocks/{id}-- {} is used to define dynamic variable id is the dynamic variable here ex : stocks/101
  * getStocks();
  * This method  is used display the User required stock item by category id .
  * this method will call  interface to get the required stock item by matching with user input and in return method will return a stock that user has asked for.
  * if categoryid mentioned in the path was not available , It will return Null.
  */
  
  @GetMapping(path = "/categoryid/{categoryid}/login/{loginid}")  
  public Stock getStockByCategoryId(@PathVariable String categoryid, @PathVariable String loginid) throws NumberFormatException, SQLException {
    return this.stockservice.getStockByCategoryIdByValidatingUser(Long.parseLong(categoryid), loginid);
  }
  
  /**
   * @GetMapping is used to retrive the data from dataBase  
   * path = localhost:8080//categoryid/{categoryid}/login/{loginid} ,  method : GET
   * /categoryid/{categoryid}/login/{loginid} -- {} is used to define dynamic variable , ex : categoryid/101/login/anil
   * getStocks();
   * This method  is used display the User required stock item by category id and by  validating the user.
   * this method will call  interface to get user required stock and in return method will return a list of stock that user has asked for.
   * if user mentioned in the path was not available , it will return Null also applicable for Categoryid
   */
  
  @GetMapping(path = "/stocks")  
  public List < Stock > getStocks() { 
    return this.stockservice.getStocks(); 
  }

  /**
   * @GetMapping is used to retrive the data from dataBase  
   * path = localhost:8080/stocks , method : GET
   * getStocks();
   * This method  is used display all the stored stocks
   * this method will call  interface to get all the stocks and in return method will return a list of stocks
   * 
   */
  
  
  @PostMapping(path = "/stocks", consumes = "application/json") 
  public Stock addStocks(@RequestBody Stock stock) {
    return this.stockservice.addStock(stock);  
  }
  
  /**
   * @PostMapping is used to insert the data into the dataBase  
   * path = localhost:8080/stocks , Method : POST
   * consumes defines the type of input that we are providing , here in our case i am sending json 
   * addStocks();
   * This method  is used insert a new entry into the database
   * this method will call  interface to insert data into the dable in return method will return the item that we have inserted.
   */
  
  
  @PutMapping(path = "/stocks", consumes = "application/json")   
  public ResponseEntity <HttpStatus>  updateStocks(@RequestBody Stock stock) { 
	  try
	  {
		  this.stockservice.updateStocks(stock);        
		  return new ResponseEntity<>(HttpStatus.ACCEPTED); 
	  }    
	  catch (Exception e) {
		  return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 

	  }
	  
	  /**
	   * @PutMapping is used to update the data in the dataBase  
	   * path = localhost:8080/stocks , method : PUT
	   * consumes defines the type of input that we are providing , here in our case i am sending json 
	   * updateStocks();
	   * This method  is used update a new  in the database , if that entry is not present then it will insert that into the table
	   * this method will call  interface to update data in the table.
	   */
  }
}