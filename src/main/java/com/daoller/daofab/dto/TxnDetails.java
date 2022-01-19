package com.daoller.daofab.dto;

/**
 * The Class TxnDetails.
 * @author Rajat Choudhari
 * @since  Java 17
 */
public class TxnDetails {
	
	/** The id. */
	private int id;
	
	/** The sender. */
	private String sender;
	
	/** The receiver. */
	private String receiver;
	
	/** The total amount. */
	private Double totalAmount;
	
	/** The total paid amount. */
	private Double paidAmount;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the sender.
	 *
	 * @return the sender
	 */
	public String getSender() {
		return sender;
	}

	/**
	 * Sets the sender.
	 *
	 * @param sender the new sender
	 */
	public void setSender(String sender) {
		this.sender = sender;
	}

	/**
	 * Gets the receiver.
	 *
	 * @return the receiver
	 */
	public String getReceiver() {
		return receiver;
	}

	/**
	 * Sets the receiver.
	 *
	 * @param receiver the new receiver
	 */
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	/**
	 * Gets the total amount.
	 *
	 * @return the total amount
	 */
	public Double getTotalAmount() {
		return totalAmount;
	}

	/**
	 * Sets the total amount.
	 *
	 * @param totalAmount the new total amount
	 */
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * Gets the paid amount.
	 *
	 * @return the paid amount
	 */
	public Double getPaidAmount() {
		return paidAmount;
	}

	/**
	 * Sets the paid amount.
	 *
	 * @param paidAmount the new paid amount
	 */
	public void setPaidAmount(Double paidAmount) {
		this.paidAmount = paidAmount;
	}
}