package project.service.message;
//M

import project.dto.message.NewPostDto;
import project.dto.message.PostDto;

public interface MessageService {
	
	PostDto createPost(NewPostDto newPostDto);
	
}
