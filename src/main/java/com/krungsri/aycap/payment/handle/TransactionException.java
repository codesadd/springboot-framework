package com.krungsri.aycap.payment.handle;

public class TransactionException extends Exception{

	private static final long serialVersionUID = 2832889188981496399L;
	private int errorCode;

	public TransactionException() {
		super("TransactionException transaction has rollback.");
	}

	public TransactionException(String message, int errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public TransactionException(String message) {
		super(message);
	}

	public TransactionException(Exception ex) {
		super(ex.getMessage(), ex.getCause());
	}

	public TransactionException(String message, Throwable cause) {
		super(message, cause);
	}

	public TransactionException(Throwable cause) {
		super(cause.getMessage(), cause);
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

}