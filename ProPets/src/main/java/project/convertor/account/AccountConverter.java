package project.convertor.account;

import org.springframework.stereotype.Component;

import project.domain.account.User;
import project.dto.account.RegisterUserDto;
import project.dto.account.UserDto;

@Component
//S
public class AccountConverter {

	public RegisterUserDto convertToRegisterUserDto(User user) {
		return RegisterUserDto.builder()
				.avatar(user.getAvatar())
				.name(user.getName())
				.email(user.getEmail())
				.roles(user.getRoles())
				.build();
	}

	public UserDto convertUserToUserDto(User user) {
		return UserDto.builder()
				.avatar(user.getAvatar())
				.name(user.getName())
				.email(user.getEmail())
				.phone(user.getPhone())
				.roles(user.getRoles())
				.block(user.getBlock())
				.build();

	
	}
}
