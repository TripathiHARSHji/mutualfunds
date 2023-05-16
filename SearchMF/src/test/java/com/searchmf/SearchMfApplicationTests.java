package com.searchmf;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.searchmf.entity.MutualFunds;
import com.searchmf.repository.MutualFundsRepository;

@SpringBootTest
class SearchMfApplicationTests {

	@Autowired
	MutualFundsRepository repo;
	
	@BeforeEach
	public void testCreate() {
	 MutualFunds mutualFunds =new MutualFunds();
	 MutualFunds mutualFund1 = new MutualFunds("Fund House 1", "Symbol 1", "Schema Name 1", "Schema Category 1", "Description 1", 100.0, 0.5);
	 MutualFunds mutualFund2 = new MutualFunds("Fund House 2", "Symbol 2", "Schema Name 2", "Schema Category 2", "Description 2", 200.0, 0.8);
	 MutualFunds mutualFund3 = new MutualFunds("Fund House 3", "Symbol 3", "Schema Name 3", "Schema Category 3", "Description 3", 300.0, 0.3);
	        repo.saveAll(List.of(mutualFund1, mutualFund2, mutualFund3));
	}

    @AfterEach
    void cleanup() {
        repo.deleteAll();
    }
	@Test
	public void testReadAll() {
		
		List<MutualFunds> list = repo.findAll();
		assertThat(list).size().isGreaterThan(0);
		
	}
	
	
}
