package com.searchmf.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.searchmf.entity.MutualFunds;

@SpringBootTest
class MutualFundsRepositoryTest {

    @Autowired
    private MutualFundsRepository repository;
    
    @AfterEach
    void cleanup() {
        repository.deleteAll();
    }

    @Test
    void searchMutualFunds_returnsMutualFundsMatchingKeyword() {
        MutualFunds mutualFund1 = new MutualFunds("Fund House 1", "Symbol 1", "Schema Name 1", "Schema Category 1", "Description 1", 100.0, 0.5);
        MutualFunds mutualFund2 = new MutualFunds("Fund House 2", "Symbol 2", "Schema Name 2", "Schema Category 2", "Description 2", 200.0, 0.8);
        MutualFunds mutualFund3 = new MutualFunds("Fund House 3", "Symbol 3", "Schema Name 3", "Schema Category 3", "Description 3", 300.0, 0.3);
        repository.saveAll(List.of(mutualFund1, mutualFund2, mutualFund3));

        List<MutualFunds> mutualFunds = repository.searchMutualFunds("Schema");
        assertThat(mutualFunds).hasSize(3);

        repository.deleteAll(List.of(mutualFund1, mutualFund2, mutualFund3));
    }

    @Test
    void searchMutualFundsById_returnsMutualFundsMatchingId() {
        MutualFunds mutualFund1 = new MutualFunds("Fund House 1", "Symbol 1", "Schema Name 1", "Schema Category 1", "Description 1", 100.0, 0.5);
        MutualFunds mutualFund2 = new MutualFunds("Fund House 2", "Symbol 2", "Schema Name 2", "Schema Category 2", "Description 2", 200.0, 0.8);
        MutualFunds mutualFund3 = new MutualFunds("Fund House 3", "Symbol 3", "Schema Name 3", "Schema Category 3", "Description 3", 300.0, 0.3);
        repository.saveAll(List.of(mutualFund1, mutualFund2, mutualFund3));

        List<MutualFunds> mutualFunds = repository.searchMutualFundsById(mutualFund1.getSchemaId().toString());
        
        assertThat(mutualFunds).hasSize(1);
        assertThat(mutualFunds.get(0).toString()).isEqualTo(mutualFund1.toString());


    }
}
