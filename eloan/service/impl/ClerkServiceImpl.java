package com.iiht.training.eloan.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.eloan.dto.LoanOutputDto;
import com.iiht.training.eloan.dto.ProcessingDto;
import com.iiht.training.eloan.entity.ProcessingInfo;
import com.iiht.training.eloan.repository.LoanRepository;
import com.iiht.training.eloan.repository.ProcessingInfoRepository;
import com.iiht.training.eloan.repository.SanctionInfoRepository;
import com.iiht.training.eloan.repository.UsersRepository;
import com.iiht.training.eloan.service.ClerkService;
import com.iiht.training.eloan.util.EMParser;

@Service
public class ClerkServiceImpl implements ClerkService {

	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private LoanRepository loanRepository;
	
	@Autowired
	private ProcessingInfoRepository ProcessingInfoRepository;
	
	@Autowired
	private SanctionInfoRepository sanctionInfoRepository;
	
	@Override
	public List<LoanOutputDto> allAppliedLoans() {
		// TODO Auto-generated method stub
		 List<LoanOutputDto> lo = null;
		 lo = loanRepository.findAll().stream().map(e -> EMParser.parse1(e)).collect(Collectors.toList());
		 for(int i =0;i<=lo.size();i++) {			 
				if(!((lo.get(i)).getRemark().equalsIgnoreCase("Applied"))) {
					lo.remove(i);
				}
				}
		 return lo;
	}

	@Override
	public ProcessingDto processLoan(Long clerkId, Long loanAppId, ProcessingDto processingDto) {
		// TODO Auto-generated method stub
		return processParse(ProcessingInfoRepository.save(EMParser.processParse(clerkId,loanAppId,processingDto)));
	}

	private ProcessingDto processParse(ProcessingInfo save) {
		// TODO Auto-generated method stub
		return null;
	}


}
