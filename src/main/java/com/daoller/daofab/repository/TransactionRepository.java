package com.daoller.daofab.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.daoller.daofab.dto.TxnDetails;

/**
 * The Interface TransactionDao.
 *
 * @author Rajat Choudhari
 * @since  Java 17
 */
public interface TransactionRepository {
	
	/**
	 * Fetch parents txn details.
	 *
	 * @param pageSize the page size
	 * @param pageNo the page no
	 * @param sortOrder the sort order
	 * @return the list
	 */
	public List<TxnDetails> fetchParentsTxnDetails(int pageSize, int pageNo, String sortOrder);

	/**
	 * Fetch child txn details.
	 *
	 * @return the list
	 * @throws DataAccessException the data access exception
	 */
	public List<TxnDetails> fetchChildTxnDetails();
}