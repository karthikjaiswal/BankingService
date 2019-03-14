package com.cg.bankservice.dto;

public class TransactionDetails {

	long fromAccountNo,toAccountNo,amountTransfered;

	public long getFromAccountNo() {
		return fromAccountNo;
	}

	public void setFromAccountNo(long fromAccountNo) {
		this.fromAccountNo = fromAccountNo;
	}

	public long getToAccountNo() {
		return toAccountNo;
	}

	public void setToAccountNo(long toAccountNo) {
		this.toAccountNo = toAccountNo;
	}

	public long getAmountTransfered() {
		return amountTransfered;
	}

	public void setAmountTransfered(long amountTransfered) {
		this.amountTransfered = amountTransfered;
	}
}
