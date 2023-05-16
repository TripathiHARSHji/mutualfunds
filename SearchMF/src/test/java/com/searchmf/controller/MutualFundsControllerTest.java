package com.searchmf.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import com.searchmf.entity.MutualFunds;
import com.searchmf.service.MutualFundService;

public class MutualFundsControllerTest {

    private MutualFundService mutualFundService;
    private MutualFundsController mutualFundsController;

    @BeforeEach
    public void setUp() {
        mutualFundService = mock(MutualFundService.class);
        mutualFundsController = new MutualFundsController(mutualFundService);
    }

    @Test
    public void testSearchFunds() {
        // Arrange
        String query = "example query";
        List<MutualFunds> expectedFunds = new ArrayList<>();
        expectedFunds.add(new MutualFunds());

        when(mutualFundService.searchFunds(query)).thenReturn(expectedFunds);

        // Act
        ResponseEntity<List<MutualFunds>> response = mutualFundsController.searchFunds(query);

        // Assert
        assertEquals(expectedFunds, response.getBody());
    }

    @Test
    public void testSearchFundsById() {
        // Arrange
        String id = "exampleId";
        List<MutualFunds> expectedFunds = new ArrayList<>();
        expectedFunds.add(new MutualFunds());

        when(mutualFundService.searchFundsById(id)).thenReturn(expectedFunds);

        // Act
        ResponseEntity<List<MutualFunds>> response = mutualFundsController.searchFundsById(id);

        // Assert
        assertEquals(expectedFunds, response.getBody());
    }

    @Test
    public void testCreateFunds() {
        // Arrange
        MutualFunds mutualFunds = new MutualFunds();
        when(mutualFundService.createProduct(mutualFunds)).thenReturn(mutualFunds);

        // Act
        MutualFunds createdFunds = mutualFundsController.createFunds(mutualFunds);

        // Assert
        assertEquals(mutualFunds, createdFunds);
    }
}
