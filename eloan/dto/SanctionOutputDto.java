package com.iiht.training.eloan.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SanctionOutputDto {
	

	@NotNull(message="Loan Amount Sanctioned is mandatory")
	@NotBlank(message="Loan Amount Sanctioned cannot be blank")
	@Min(value = 1)
	private Double loanAmountSanctioned;
	
	@NotNull(message="Term of Loan is mandatory")
	@NotBlank(message="Term of Loan cannot be blank")
	@Min(value = 1)
	private Double termOfLoan;
	
	@NotNull(message="Payment Start Date is mandatory")
	@NotBlank(message="Payment Start Date cannot be blank")
	private String paymentStartDate;
	
	@NotNull(message="Laon Closure Date is mandatory")
	@NotBlank(message="Laon Closure Date cannot be blank")
	private String loanClosureDate;
	
	@NotNull(message="Monthly Payment is mandatory")
	@NotBlank(message="Monthly Payment cannot be blank")
	private Double monthlyPayment;
	
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
	public String getLoanClosureDate() {
		return loanClosureDate;
	}
	public void setLoanClosureDate(String loanClosureDate) {
		this.loanClosureDate = loanClosureDate;
	}
	public Double getMonthlyPayment() {
		return monthlyPayment;
	}
	public void setMonthlyPayment(Double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}
	
	
}
