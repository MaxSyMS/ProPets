package project.service.message;


import project.dto.message.NewPostDto;
import project.dto.message.PostDto;
//M
public interface MessageService {
	
	PostDto createPost(NewPostDto newPostDto, String ownerId);

	PostDto updatePost(NewPostDto newPostDto, String id);

	PostDto deletePost(String id);

	PostDto getPostById(String id);

	Iterable<PostDto> viewPosts(int items_on_page, int current_page);

	void complainOnPost(String id);

	void hidePost(String id);
	
}
