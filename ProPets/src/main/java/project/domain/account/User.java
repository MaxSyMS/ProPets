package project.domain.account;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode(of = {"email"})
@Document(collection = "users")
//S
public class User {
	String avatar;
	String name;
	@Id
	String email;
	String phone;
	Boolean block;
	@Singular
	Set<String> roles;
	@Singular
	Set<String> favoritePosts;
	
	public void addRole(String role) {
		roles.add(role);
	}
	
	public void removeRole(String role) {
		roles.remove(role);
	}
	
	public void addFavorite(String postId) {
		roles.add(postId);
	}
	
	public void removeFavorite(String postId) {
		roles.remove(postId);
	}


	
}
