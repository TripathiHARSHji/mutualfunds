package com.searchmf.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.searchmf.entity.MutualFunds;


public interface MutualFundsRepository extends JpaRepository<MutualFunds, Long> {
	

		
	   @Query(value ="SELECT * FROM Mutual_funds  WHERE schema_name LIKE CONCAT('%', :keyword, '%') OR schema_category LIKE CONCAT('%', :keyword, '%') OR fund_house LIKE CONCAT('%', :keyword, '%')  limit 5",nativeQuery = true )
	    List<MutualFunds> searchMutualFunds( String keyword);
	   
	   @Query(value="SELECT * FROM Mutual_funds WHERE schema_id = :id",nativeQuery = true )
	   List<MutualFunds> searchMutualFundsById(String id);
	   
}

    
    