package com.springrest.springrest.stock;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

/**
 * @entity is like defining this class is the entity class
 * @author PokaVenkataAnilKumar
 *
 */
public class Stock {
	
@Id	
private long CategoryId;
/**
 * @ID is used to define the variable that is coming after that is a primary key of that table
 */
private String StockName;
private double Price;

public Stock(long categoryId, String stockName, double price) {
	super();
	CategoryId = categoryId;
	StockName = stockName;
	Price = price;
}

/**
 * Parametirized constructor
 */

public Stock() {
	super();
}


/**
 * Default constructor
 */

public long getCategoryId() {
	return CategoryId;
}
public void setCategoryId(long categoryId) {
	CategoryId = categoryId;
}
public String getStockName() {
	return StockName;
}
public void setStockName(String stockName) {
	StockName = stockName;
}
public double getPrice() {
	return Price;
}
public void setPrice(double price) {
	Price = price;
}

/**
 * setter and getter for all the variable used to retrive or update the data.
 */

@Override
public String toString() {
	return "Stock [CategoryId=" + CategoryId + ", StockName=" + StockName + ", Price="
			+ Price + ", getCategoryId()=" + getCategoryId() + ", getStockName()=" + getStockName() + ", getPrice()=" + getPrice() + ", getClass()=" + getClass()
			+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
} 

}
