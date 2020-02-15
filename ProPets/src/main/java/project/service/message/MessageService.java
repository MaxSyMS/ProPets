package project.service.message;


import project.dto.message.NewPostDto;
import project.dto.message.PostDto;
//M
public interface MessageService {
	
	PostDto createPost(NewPostDto newPostDto, String ownerId);

	PostDto updatePost(NewPostDto newPostDto, String ownerId);

	PostDto deletePost(String ownerId);

	PostDto getPostById(String id);
	
}
