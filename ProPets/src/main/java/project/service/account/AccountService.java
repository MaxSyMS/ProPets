package project.service.account;

import project.dto.account.BlockUserDto;
import project.dto.account.EditUserDto;
import project.dto.account.NewUserDto;
import project.dto.account.RegisterUserDto;
import project.dto.account.RolesDto;
import project.dto.account.UserDto;
import project.dto.message.PostDto;

public interface AccountService {

	RegisterUserDto registerUser(NewUserDto newUser);

	UserDto loginUser(String token);

	UserDto userInformation(String login, String token);

	UserDto editUserProfile(EditUserDto editUser, String login, String token);

	UserDto removeUser(String login, String token);

	RolesDto addRoles(String login, RolesDto roles, String token);

	BlockUserDto blockUserAccount(String login, BlockUserDto blockUser, String token, boolean status);

	PostDto addUserFavorite(String login, String id, String token);

	PostDto removeUserFavorite(String login, String id, String token);

	Iterable<PostDto> getUserFavorites(String login, String token);

}
