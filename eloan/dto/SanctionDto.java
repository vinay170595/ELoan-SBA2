package com.iiht.training.eloan.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SanctionDto {
	
	@NotNull(message="Loan Amount Sanctioned is mandatory")
	@NotBlank(message="Loan Amount Sanctioned cannot be blank")
	@Min(value = 1)
	private Double loanAmountSanctioned;
	
	@NotNull(message="Term of Loan is mandatory")
	@NotBlank(message="Term of Loan cannot be blank")
	@Min(value = 1)
	private Double termOfLoan;
	
	private String paymentStartDate;
	
	public Double getLoanAmountSanctioned() {
		return loanAmountSanctioned;
	}
	public void setLoanAmountSanctioned(Double loanAmountSanctioned) {
		this.loanAmountSanctioned = loanAmountSanctioned;
	}
	public Double getTermOfLoan() {
		return termOfLoan;
	}
	public void setTermOfLoan(Double termOfLoan) {
		this.termOfLoan = termOfLoan;
	}
	public String getPaymentStartDate() {
		return paymentStartDate;
	}
	public void setPaymentStartDate(String paymentStartDate) {
		this.paymentStartDate = paymentStartDate;
	}
	
	
}
