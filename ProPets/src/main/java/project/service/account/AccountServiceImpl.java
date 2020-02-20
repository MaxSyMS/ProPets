package project.service.account;

import org.springframework.stereotype.Service;

import project.dto.account.BlockUserDto;
import project.dto.account.EditUserDto;
import project.dto.account.NewUserDto;
import project.dto.account.RegisterUserDto;
import project.dto.account.RolesDto;
import project.dto.account.UserDto;
import project.dto.message.PostDto;

@Service
public class AccountServiceImpl implements AccountService {

	@Override
	public RegisterUserDto registerUser(NewUserDto newUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto loginUser(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto userInformation(String login, String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto editUserProfile(EditUserDto editUser, String login, String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto removeUser(String login, String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RolesDto addRoles(String login, RolesDto roles, String token) {
		// TODO Auto-generated method stub
		return null;
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

}
