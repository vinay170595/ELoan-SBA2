package com.iiht.training.eloan.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import com.iiht.training.eloan.dto.LoanDto;
import com.iiht.training.eloan.dto.LoanOutputDto;
import com.iiht.training.eloan.dto.ProcessingDto;
import com.iiht.training.eloan.dto.RejectDto;
import com.iiht.training.eloan.dto.SanctionDto;
import com.iiht.training.eloan.dto.SanctionOutputDto;
import com.iiht.training.eloan.dto.UserDto;
import com.iiht.training.eloan.entity.Loan;
import com.iiht.training.eloan.entity.ProcessingInfo;
import com.iiht.training.eloan.entity.SanctionInfo;
import com.iiht.training.eloan.entity.Users;
import com.iiht.training.eloan.repository.LoanRepository;

public class EMParser {

	static LoanRepository loanRepository;
	static Loan loanInf;

	public static Users parse(UserDto source) {
		Users target = new Users();
		target.setId(source.getId());
		target.setFirstName(source.getFirstName());
		target.setLastName(source.getLastName());
		target.setEmail(source.getEmail());
		target.setMobile(source.getMobile());
		target.setRole("customer");
		return target;
	}
	
	public static UserDto parse(Users source) {
		UserDto target = new UserDto();
		target.setId(source.getId());
		target.setFirstName(source.getFirstName());
		target.setLastName(source.getLastName());
		target.setEmail(source.getEmail());
		target.setMobile(source.getMobile());
		return target;
	}
	
	public static Loan parse(LoanDto source) {
		Loan target = new Loan();
		target.setCustomerId(target.getId());
		target.setLoanName(source.getLoanName());
		target.setLoanAmount(source.getLoanAmount());
		target.setLoanApplicationDate(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
		target.setBusinessStructure(source.getBusinessStructure());
		target.setBillingIndicator(source.getBillingIndicator());
		target.setTaxIndicator(source.getTaxIndicator());
		target.setStatus(0);
		target.setRemark("Applied");
		return target;
	}
	public static LoanDto parse(Loan source) {
		LoanDto target = new LoanDto();
		target.setLoanName(source.getLoanName());
		target.setLoanAmount(source.getLoanAmount());
		target.setLoanApplicationDate(source.getLoanApplicationDate());
		target.setBusinessStructure(source.getBusinessStructure());
		target.setBillingIndicator(source.getBillingIndicator());
		target.setTaxIndicator(source.getTaxIndicator());
		
		return target;
	}
	
	public static LoanOutputDto parse1(Loan source) {
		LoanDto loanDto = new LoanDto();
		LoanOutputDto loanOutputDto = new LoanOutputDto();
		loanOutputDto.setCustomerId(source.getCustomerId());
		loanOutputDto.setLoanAppId(source.getId());
		loanOutputDto.setLoanDto(loanDto);
		loanOutputDto.setStatus(source.getStatus());
		loanOutputDto.setRemark(source.getRemark());
		
		return loanOutputDto;
	}
	public static UserDto clerkParse(Users source) {
		UserDto target = new UserDto();
		target.setId(source.getId());
		target.setFirstName(source.getFirstName());
		target.setLastName(source.getLastName());
		target.setEmail(source.getEmail());
		target.setMobile(source.getMobile());
		target.setRole(source.getRole());
		return target;
	}
	
	public static Users clerkParse(UserDto source) {
		Users target = new Users();
		target.setId(source.getId());
		target.setFirstName(source.getFirstName());
		target.setLastName(source.getLastName());
		target.setEmail(source.getEmail());
		target.setMobile(source.getMobile());
		target.setRole("clerk");
		
		return target;
	}
	
	public static UserDto managerParse(Users source) {
		UserDto target = new UserDto();
		target.setId(source.getId());
		target.setFirstName(source.getFirstName());
		target.setLastName(source.getLastName());
		target.setEmail(source.getEmail());
		target.setMobile(source.getMobile());
		target.setRole(source.getRole());
		return target;
	}
	
	public static Users managerParse(UserDto source) {
		Users target = new Users();
		target.setId(source.getId());
		target.setFirstName(source.getFirstName());
		target.setLastName(source.getLastName());
		target.setEmail(source.getEmail());
		target.setMobile(source.getMobile());
		target.setRole("manager");
		
		return target;
	}
	
	public static ProcessingInfo processParse(Long clerkId, Long loanAppId, ProcessingDto source) {
		ProcessingInfo target = new ProcessingInfo();
		
		target.setAcresOfLand(source.getAcresOfLand());
		target.setAddressOfProperty(source.getAddressOfProperty());
		target.setAppraisedBy(clerkId.toString());
		target.setLandValue(source.getLandValue());
		target.setLoanAppId(loanAppId);
		target.setLoanClerkId(clerkId);
		target.setSuggestedAmountOfLoan(source.getSuggestedAmountOfLoan());
		target.setValuationDate(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));		
		Loan loanInf = loanRepository.findById(loanAppId).get();
		loanInf.setRemark("Processed");
		loanInf.setStatus(1);
		return target;
		}

	public static ProcessingDto processParse(ProcessingInfo source) {
		ProcessingDto target = new ProcessingDto();
		
		target.setAcresOfLand(source.getAcresOfLand());
		target.setAddressOfProperty(source.getAddressOfProperty());
		target.setLandValue(source.getLandValue());
		target.setSuggestedAmountOfLoan(source.getSuggestedAmountOfLoan());
		target.setValuationDate(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
		return target;
	}
	public static SanctionInfo sanctionParse(Long managerId, Long loanAppId, SanctionDto source) {
		SanctionInfo target = new SanctionInfo();
		
		target.setManagerId(managerId);
		target.setLoanAppId(loanAppId);
		target.setLoanAmountSanctioned(source.getLoanAmountSanctioned());
		target.setTermOfLoan(source.getTermOfLoan());
		target.setPaymentStartDate(source.getPaymentStartDate());
		
		int interestRate = 10;
		int totalPaymentAmt = (int) ((source.getLoanAmountSanctioned()) * Math.pow((1+interestRate/100),source.getTermOfLoan()/12));
		double loanEmiAmt = totalPaymentAmt / (source.getTermOfLoan()/12);
		LocalDate loanClosureDt = LocalDate.now().plusMonths((long) (source.getTermOfLoan()+1));		
		target.setLoanClosureDate(loanClosureDt.toString());
		target.setMonthlyPayment(loanEmiAmt);
		loanInf.setRemark("Sanctioned");
		loanInf.setStatus(2);
		return target;
		}

	public static SanctionOutputDto sanctionParse(SanctionInfo source) {
		SanctionOutputDto target = new SanctionOutputDto();
		
		target.setLoanAmountSanctioned(source.getLoanAmountSanctioned());
		target.setTermOfLoan(source.getTermOfLoan());
		target.setPaymentStartDate(source.getPaymentStartDate());
		target.setLoanClosureDate(source.getLoanClosureDate());
		target.setMonthlyPayment(source.getMonthlyPayment());
		
		return target;
	}
	public static RejectDto rejectParse(Loan loanObj) {
		RejectDto rejectDto = new RejectDto();
		rejectDto.setRemark("Rejected");
		
		return rejectDto;
	}

	public static Loan rejectParse(Long managerId, Long loanAppId, RejectDto source) {
		Loan loanInf = loanRepository.findById(loanAppId).get();
		loanInf.setRemark("Rejected");
		loanInf.setStatus(-1);
		return loanInf;
	}
}
