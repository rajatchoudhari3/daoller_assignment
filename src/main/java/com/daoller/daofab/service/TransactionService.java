package com.daoller.daofab.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.daoller.daofab.dto.TxnDetails;

/**
 * The Interface TransactionService.
 *
 * @author Rajat Choudhari
 * @since  Java 17
 */
public interface TransactionService{
	
	/**
	 * Gets the parents txn details.
	 *
	 * @param pageSize the page size
	 * @param pageNo the page no
	 * @param sortOrder the sort order
	 * @return the parents txn details
	 * @throws DataAccessException the data access exception
	 */
	public List<TxnDetails> getParentsTxnDetails(int pageSize, int pageNo, String sortOrder)
			throws DataAccessException;
	
	/**
	 * Gets the child txn details.
	 *
	 * @param parentId the parent id
	 * @return the child txn details
	 * @throws DataAccessException the data access exception
	 */
	public List<TxnDetails> getChildTxnDetails() throws DataAccessException;
}