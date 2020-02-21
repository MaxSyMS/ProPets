package project.service.account;

import java.util.Base64;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.convertor.account.AccountConverter;
import project.dao.account.AccountRepository;
import project.domain.account.User;
import project.dto.account.BlockUserDto;
import project.dto.account.EditUserDto;
import project.dto.account.NewUserDto;
import project.dto.account.RegisterUserDto;
import project.dto.account.UserDto;
import project.dto.message.PostDto;
import project.exseptions.account.ConflictException;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;
	@Autowired
	AccountConverter convertor;
	
	@Override
	public RegisterUserDto registerUser(NewUserDto newUser) {
		String login = newUser.getEmail();
		String password = newUser.getPassword();
		if (login == null || password == null) {
			throw new ConflictException();
		}
		if (accountRepository.existsById(login)) {
			throw new ConflictException();
		}
		User user = User.builder()
				.avatar("https://www.gravatar.com/avatar/0?d=mp")
				.email(newUser.getEmail())
				.name(newUser.getName())
				.block(false)
				.role("ROLE_USER")
				.favoritePosts(new HashSet<String>())
				.build();
		user = accountRepository.save(user);
		return convertor.convertToRegisterUserDto(user);
	}

	@Override
	public UserDto loginUser(String token) {
		String login = getLoginFromCredential(token);
		User user = accountRepository.findById(login).get();
		return convertor.convertUserToUserDto(user);
	}

	@Override
	public UserDto userInformation(String login, String token) {
		String email = getLoginFromCredential(token);
		if (email != login) {
			throw new ConflictException();
		}
		User user = accountRepository.findById(login).get();
		return convertor.convertUserToUserDto(user);
	}

	@Override
	public UserDto editUserProfile(EditUserDto editUser, String login, String token) {
		String email = getLoginFromCredential(token);
		if (email != login) {
			throw new ConflictException();
		}
		User user = accountRepository.findById(login).get();
		if (editUser.getAvatar() != null) {
			user.setAvatar(editUser.getAvatar());
		}
		if (editUser.getName() != null) {
			user.setName(editUser.getName());
		}
		if (editUser.getPhone() != null) {
			user.setPhone(editUser.getPhone());
		}
		accountRepository.save(user);
		return convertor.convertUserToUserDto(user);
	}

	@Override
	public UserDto removeUser(String login, String token) {
		String email = getLoginFromCredential(token);
		if (email != login) {
			throw new ConflictException();
		}
		User user = accountRepository.findById(login).get();
		accountRepository.deleteById(login);
		return convertor.convertUserToUserDto(user);
	}

	@Override
	public Set<String> addRoles(String login, String role, String token) {
		String email = getLoginFromCredential(token);
		User admin = accountRepository.findById(email).orElseThrow(() -> new ConflictException());
		if (!admin.getRoles().contains("ROLE_ADMIN")) {
			throw new ConflictException();
		}
		User user = accountRepository.findById(login).get();
		user.addRole(role);
		accountRepository.save(user);
		return user.getRoles();
		//1
	}

	@Override
	public BlockUserDto blockUserAccount(String login, BlockUserDto blockUser, String token, boolean status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDto addUserFavorite(String login, String id, String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDto removeUserFavorite(String login, String id, String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<PostDto> getUserFavorites(String login, String token) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private String[] decodeToken(String token) {
		int pos = token.indexOf(" ");
		String newToken = token.substring(pos + 1);
		byte[] decodeBytes = Base64.getDecoder().decode(newToken);
		String credential = new String(decodeBytes);
		String[] credentials = credential.split(":");
		return credentials;
	}
	
	private String getLoginFromCredential(String token) {
		String[] credential = decodeToken(token);
		return credential[0];
	}

}
