package com.daoller.daofab.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.daoller.daofab.dto.TxnDetails;

/**
 * The Class TxnMapper.
 *
 * @author Rajat Choudhari
 * @since  Java 17
 */
public class TxnMapper implements RowMapper<TxnDetails>{

	@Override
	public TxnDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
        TxnDetails txnDetails = new TxnDetails();
        txnDetails.setId(rs.getInt("id"));
        txnDetails.setSender(rs.getString("sender"));
        txnDetails.setReceiver(rs.getString("receiver"));
        txnDetails.setTotalAmount(rs.getDouble("total_amount"));
        txnDetails.setPaidAmount(rs.getDouble("paid_amount"));
		return txnDetails;
	}
}
