package com.iiht.training.eloan.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.eloan.dto.UserDto;
import com.iiht.training.eloan.exception.InvalidDataException;
import com.iiht.training.eloan.repository.UsersRepository;
import com.iiht.training.eloan.service.AdminService;
import com.iiht.training.eloan.util.EMParser;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private UsersRepository usersRepository;
	@Transactional
	@Override
	public UserDto registerClerk(UserDto userDto) throws InvalidDataException {
			userDto = EMParser.parse(usersRepository.save(EMParser.clerkParse(userDto)));
		return userDto;
	}

	@Override
	public UserDto registerManager(UserDto userDto) throws InvalidDataException {
			userDto = EMParser.parse(usersRepository.save(EMParser.managerParse(userDto)));
		return userDto;
		
}

	@Override
	public List<UserDto> getAllClerks() {
		// TODO Auto-generated method stub
		return usersRepository.findAllByRole("clerk").stream().map(e -> EMParser.parse(e)).collect(Collectors.toList());
	}
		
	

	@Override
	public List<UserDto> getAllManagers() {
		// TODO Auto-generated method stub
		return usersRepository.findAllByRole("manager").stream().map(e -> EMParser.parse(e)).collect(Collectors.toList());
	}

}
