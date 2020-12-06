package com.iiht.training.eloan.dto;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class LoanDto {

	@NotNull(message="Loan Name is mandatory")
	@NotBlank(message="Loan Name cannot be null")
	private String loanName;
	
	@NotNull(message="Loan Amount is mandatory")
	@Min(value=1)
	private Double loanAmount;
	
	@NotNull(message="Loan Application Date should not be null")
	@NotBlank(message="Loan Application Date cant be blank")
	private String loanApplicationDate;
	
	private String businessStructure;
	private String billingIndicator;
	private String taxIndicator;
	public String getLoanName() {
		return loanName;
	}
	public void setLoanName(String loanName) {
		this.loanName = loanName;
	}
	public Double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public String getLoanApplicationDate() {
		return loanApplicationDate;
	}
	public void setLoanApplicationDate(String loanApplicationDate) {
		this.loanApplicationDate = loanApplicationDate;
	}
	public String getBusinessStructure() {
		return businessStructure;
	}
	public void setBusinessStructure(String businessStructure) {
		this.businessStructure = businessStructure;
	}
	public String getBillingIndicator() {
		return billingIndicator;
	}
	public void setBillingIndicator(String billingIndicator) {
		this.billingIndicator = billingIndicator;
	}
	public String getTaxIndicator() {
		return taxIndicator;
	}
	public void setTaxIndicator(String taxIndicator) {
		this.taxIndicator = taxIndicator;
	}
	
	
}
