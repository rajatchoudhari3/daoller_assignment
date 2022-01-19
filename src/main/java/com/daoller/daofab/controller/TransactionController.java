package com.daoller.daofab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daoller.daofab.dto.TransactionResponse;
import com.daoller.daofab.dto.TxnDetails;
import com.daoller.daofab.service.TransactionService;

@RestController
public class TransactionController {

	@Autowired
	private TransactionService txnService;

	@GetMapping("/parents")
	public ResponseEntity<TransactionResponse> getParentsTxnDetails(@RequestParam("pageSize") int pageSize,
			@RequestParam("pageNo") int pageNo, @RequestParam("sortOrder") String sortOrder) {
		TransactionResponse response = new TransactionResponse();
		List<TxnDetails> parentsTxnDetails = txnService.getParentsTxnDetails(pageSize, pageNo, sortOrder);
		if (parentsTxnDetails == null || parentsTxnDetails.isEmpty()) {
			response.setStatus("Failed");
			response.setMessage("Requested data not found");
			return new ResponseEntity<TransactionResponse>(response, HttpStatus.NOT_FOUND);
		} else {
			response.setStatus("Success");
			response.setMessage("Requested data provided");
			response.setData(parentsTxnDetails);
		}
		return new ResponseEntity<TransactionResponse>(response, HttpStatus.OK);
	}

	@GetMapping("/children")
	public ResponseEntity<TransactionResponse> getChildTxnDetails() {
		TransactionResponse response = new TransactionResponse();
		List<TxnDetails> childTxnDetails = txnService.getChildTxnDetails();
		if (childTxnDetails == null || childTxnDetails.isEmpty()) {
			response.setStatus("Failed");
			response.setMessage("Requested data not found");
			return new ResponseEntity<TransactionResponse>(response, HttpStatus.NOT_FOUND);
		} else {
			response.setStatus("Success");
			response.setMessage("Requested data provided");
			response.setData(childTxnDetails);
		}
		return new ResponseEntity<TransactionResponse>(response, HttpStatus.OK);
	}
}
