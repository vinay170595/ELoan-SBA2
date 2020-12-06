package com.iiht.training.eloan.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.eloan.dto.LoanDto;
import com.iiht.training.eloan.dto.LoanOutputDto;
import com.iiht.training.eloan.dto.UserDto;
import com.iiht.training.eloan.exception.CustomerNotFoundException;
import com.iiht.training.eloan.exception.LoanNotFoundException;
import com.iiht.training.eloan.repository.LoanRepository;
import com.iiht.training.eloan.repository.ProcessingInfoRepository;
import com.iiht.training.eloan.repository.SanctionInfoRepository;
import com.iiht.training.eloan.repository.UsersRepository;
import com.iiht.training.eloan.service.CustomerService;
import com.iiht.training.eloan.util.EMParser;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private UsersRepository usersRepository;
		
	@Autowired
	private LoanRepository loanRepository;
	
	@Autowired
	private ProcessingInfoRepository pProcessingInfoRepository;
	
	@Autowired
	private SanctionInfoRepository sanctionInfoRepository;
	
	@Transactional
	@Override
	public UserDto register(UserDto userDto) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		if(userDto!=null) {
			if(usersRepository.existsById(userDto.getId())) {
				throw new CustomerNotFoundException("User#"+userDto.getId()+"already exists");
			}
			userDto = EMParser.parse(usersRepository.save(EMParser.parse(userDto)));
			
		}
		 return userDto;
	}
	
	@Transactional
	@Override
	public LoanOutputDto applyLoan(Long customerId, LoanDto loanDto) {
		// TODO Auto-generated method stub
		LoanOutputDto loanOutput = null;
		loanDto =EMParser.parse(loanRepository.save(EMParser.parse(loanDto)));
		return loanOutput;
	}
	
	@Transactional
	@Override
	public LoanOutputDto getStatus(Long loanAppId) {
		// TODO Auto-generated method stub
		if(!loanRepository.existsById(loanAppId)) {
			throw new LoanNotFoundException("Loan Id #"+loanAppId+" does not exist");
		}
		return EMParser.parse1(loanRepository.findById(loanAppId).get());
		
		
	}
	
	@Transactional
	@Override
	public List<LoanOutputDto> getStatusAll(Long customerId) {
		// TODO Auto-generated method stub
		return loanRepository.findAllByCustomerId((customerId)).stream().map(e -> EMParser.parse1(e)).collect(Collectors.toList());
	}

}
