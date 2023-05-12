package com.searchmf.service;

import java.util.List;
import com.searchmf.entity.MutualFunds;

public interface MutualFundService {
    List<MutualFunds> searchFunds(String query);
    List<MutualFunds> searchFundsById(String id);
   

    MutualFunds createProduct(MutualFunds mutualFunds);
}