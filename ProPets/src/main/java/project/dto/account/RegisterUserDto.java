package project.dto.account;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
//S
public class RegisterUserDto {
	String avatar;
	String name;
	String email;
	Set<String> roles;
}
