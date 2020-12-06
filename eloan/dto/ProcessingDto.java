package com.iiht.training.eloan.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProcessingDto {
	
	@NotNull(message="Acres of Land is mandatory")
	@NotBlank(message="Acres of Land cannot be blank")
	@DecimalMin(value = "0.1")
	private Double acresOfLand;
	
	@NotNull(message="Land Value is mandatory")
	@NotBlank(message="Land Value cannot be blank")
	@Min(value = 1)
	private Double landValue;
	
	private String appraisedBy;
	private String valuationDate;
	
	@NotNull(message="Address Of Property is mandatory")
	@NotBlank(message="Address Of Property cannot be blank")
	private String addressOfProperty;

	@NotNull(message="Suggested Amount of Loan is mandatory")
	@NotBlank(message="Suggested Amount of Loan cannot be blank")
	private Double suggestedAmountOfLoan;
	
	public Double getAcresOfLand() {
		return acresOfLand;
	}
	public void setAcresOfLand(Double acresOfLand) {
		this.acresOfLand = acresOfLand;
	}
	public Double getLandValue() {
		return landValue;
	}
	public void setLandValue(Double landValue) {
		this.landValue = landValue;
	}
	public String getAppraisedBy() {
		return appraisedBy;
	}
	public void setAppraisedBy(String appraisedBy) {
		this.appraisedBy = appraisedBy;
	}
	public String getValuationDate() {
		return valuationDate;
	}
	public void setValuationDate(String valuationDate) {
		this.valuationDate = valuationDate;
	}
	public String getAddressOfProperty() {
		return addressOfProperty;
	}
	public void setAddressOfProperty(String addressOfProperty) {
		this.addressOfProperty = addressOfProperty;
	}
	public Double getSuggestedAmountOfLoan() {
		return suggestedAmountOfLoan;
	}
	public void setSuggestedAmountOfLoan(Double suggestedAmountOfLoan) {
		this.suggestedAmountOfLoan = suggestedAmountOfLoan;
	}
	
	
}
