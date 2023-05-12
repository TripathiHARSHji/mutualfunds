package com.searchmf.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.searchmf.entity.MutualFunds;
import com.searchmf.service.MutualFundService;

@RestController
@RequestMapping("/mutualfunds")
public class MutualFundsController {

    private MutualFundService mutualFundService;

    public MutualFundsController(MutualFundService mutualFundService) {
        this.mutualFundService = mutualFundService;
    }
    
    @GetMapping("/search")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<MutualFunds>> searchFunds(@RequestParam("query") String query){
        return ResponseEntity.ok(mutualFundService.searchFunds(query));
    }

    
    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<MutualFunds>> searchFundsById(@PathVariable("id") String id){
        return ResponseEntity.ok(mutualFundService.searchFundsById(id));
    }
    
    @PostMapping
    public MutualFunds createFunds(@RequestBody MutualFunds mutualFunds){
        return mutualFundService.createProduct(mutualFunds);
    }}