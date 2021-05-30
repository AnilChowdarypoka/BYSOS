package com.springrest.springrest.services;
import java.sql.SQLException;
import java.util.List;
import com.springrest.springrest.stock.Stock;
public interface stockService {
	
	/**
	 * These all are Abstract methods , Which were further implemented by stockDetails Class (Service Class) where it's behavior was mentioned
	 * @param CategoryId
	 * 
	 */
	
	public Stock getStockByCategoryId(long CategoryId);   
	public Stock getStockByCategoryIdByValidatingUser(long CategoryId , String id) throws SQLException;
	public Stock addStock(Stock stock);
	public List<Stock> getStocks();
	public void updateStocks(Stock stock);
	
}
