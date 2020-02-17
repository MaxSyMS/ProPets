package project.service.message;


import project.dto.message.NewPostDto;
import project.dto.message.PostDto;
import project.dto.message.ViewPostDto;
//M
public interface MessageService {
	
	PostDto createPost(NewPostDto newPostDto, String ownerId);

	PostDto updatePost(NewPostDto newPostDto, String id);

	PostDto deletePost(String id);

	PostDto getPostById(String id);

	ViewPostDto viewPosts(int items_on_page, int current_page, String user);

	void complainOnPost(String id);

	void hidePost(String id, String user);
	
}
