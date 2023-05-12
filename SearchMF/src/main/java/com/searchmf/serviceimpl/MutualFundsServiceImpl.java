package com.searchmf.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.searchmf.entity.MutualFunds;
import com.searchmf.repository.MutualFundsRepository;
import com.searchmf.service.MutualFundService;


@Service
public class MutualFundsServiceImpl implements MutualFundService {

	@Autowired
	private MutualFundsRepository mutualFundsRepository;
	
	
	@Override
	public List<MutualFunds> searchFunds(String query) {
		// TODO Auto-generated method stub
		List<MutualFunds> mutualFunds = mutualFundsRepository.searchMutualFunds(query);
		return mutualFunds;
	}
	
	@Override
	public List<MutualFunds> searchFundsById(String id){
		List<MutualFunds> mutualFunds = mutualFundsRepository.searchMutualFundsById(id);
		return mutualFunds;
	}

	@Override
	public MutualFunds createProduct(MutualFunds mutualFunds) {
		// TODO Auto-generated method stub
		return mutualFundsRepository.save(mutualFunds);
	}
	


}
