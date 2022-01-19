package com.daoller.daofab.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daoller.daofab.dto.TxnDetails;
import com.daoller.daofab.repository.TransactionRepository;
import com.daoller.daofab.service.TransactionService;

/**
 * The Class TransactionServiceImpl.
 *
 * @author Rajat Choudhari
 * @since  Java 17
 */
@Service
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	private TransactionRepository txnRepository;

	@Override
	public List<TxnDetails> getParentsTxnDetails(int pageSize, int pageNo, String sortOrder){
		List<TxnDetails> parentsTxnDetails = txnRepository.fetchParentsTxnDetails(pageSize, pageNo, sortOrder);
		return parentsTxnDetails;
	}

	@Override
	public List<TxnDetails> getChildTxnDetails(){
		List<TxnDetails> childTxnDetails = txnRepository.fetchChildTxnDetails();
		return childTxnDetails;
	}
}
