package com.daoller.daofab.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.daoller.daofab.dto.TxnDetails;
import com.daoller.daofab.repository.TransactionRepository;
import com.daoller.daofab.rowmapper.TxnMapper;

/**
 * The Class TransactionDaoImpl.
 * 
 * @author Rajat Choudhari
 * @since  Java 17
 */
@Repository
public class TransactionRepositoryImpl implements TransactionRepository{

	/** The parents txn query. */
	private final String PARENTS_TXN_QUERY = "select tp.id,tp.sender,tp.receiver,tp.total_amount, sum(paid_amount) as paid_amount from tbl_parent tp join tbl_child tc on tc.parent_id = tp.id group by tc.parent_id order by tp.id ";
	
	/** The child txn query. */
	private final String CHILD_TXN_QUERY = "select tc.id,tp.sender,tp.receiver,tp.total_amount,tc.paid_amount from tbl_parent tp inner join tbl_child tc on tc.parent_id = tp.id";
	
	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<TxnDetails> fetchParentsTxnDetails(int pageSize, int pageNo, String sortOrder){
		List<TxnDetails> parentsTxnDetails = null;
		try {
			String query = PARENTS_TXN_QUERY + sortOrder + " limit ?,?";
			parentsTxnDetails = jdbcTemplate.query(query, new TxnMapper(), 2 * (pageNo - 1),
					pageSize);
		} catch (DataAccessException ex) {
			ex.printStackTrace();
		}
		return parentsTxnDetails;
	}

	@Override
	public List<TxnDetails> fetchChildTxnDetails(){
		List<TxnDetails> childTxnDetails = null;
		try {
			childTxnDetails = jdbcTemplate.query(CHILD_TXN_QUERY, new TxnMapper());
		}catch(DataAccessException ex) {
			ex.printStackTrace();
		}
		return childTxnDetails;
	}
}