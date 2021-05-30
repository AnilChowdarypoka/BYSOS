package com.springrest.springrest.Db;
import org.springframework.data.jpa.repository.JpaRepository;
import com.springrest.springrest.stock.Stock;
public interface Dao extends JpaRepository <Stock , Long>{

}
