package com.globallogic.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.globallogic.dto.AddressDto;
import com.globallogic.dto.UserDto;
import com.globallogic.entity.Address;
import com.globallogic.entity.User;
import com.globallogic.exception.EmailAlreadyExistsInDatabaseException;
import com.globallogic.exception.UserNameAlreadyTakenException;
import com.globallogic.repository.UserRepository;
import com.globallogic.service.UserService;
import com.globallogic.util.UserConstants;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * @description : Registers a user
	 * @param userDto : Takes UserDto as parameters
	 * @return userDto : Returns UserDto
	 * @throws EmailAlreadyExistsInDatabaseException, UserNameAlreadyTakenException
	 */
	@Override
	public void registerUser(UserDto userDto) {

		if (userRepository.existsByEmail(userDto.getEmail())) {

			throw new EmailAlreadyExistsInDatabaseException(UserConstants.EMAIL_ALREADY_EXISTS);
		}

		if (userRepository.existsByUsername(userDto.getUsername())) {
			throw new UserNameAlreadyTakenException(UserConstants.USER_NAME_ALREADY_TAKEN);
		}
		User user = convertDtoToEntity(userDto);
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		userRepository.save(user);
	}

	/**
	 * Converts entity to dto
	 */
	private static UserDto convertEntityToDto(User user) {

		UserDto userDto = new ModelMapper().map(user, UserDto.class);
		AddressDto addressDto = new ModelMapper().map(user.getAddress(), AddressDto.class);
		userDto.setAddress(addressDto);
		return userDto;

	}

	/**
	 * Converts dto to entity
	 */
	private static User convertDtoToEntity(UserDto userDto) {

		User user = new ModelMapper().map(userDto, User.class);
		Address address = new ModelMapper().map(userDto.getAddress(), Address.class);
		user.setAddress(address);
		return user;

	}

}
