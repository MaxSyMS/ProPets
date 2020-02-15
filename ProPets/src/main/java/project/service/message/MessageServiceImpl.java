package project.service.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.dao.MessageRepository;
import project.dto.message.NewPostDto;
import project.dto.message.PostDto;

@Service
//m
public class MessageServiceImpl implements MessageService {
	@Autowired
	MessageRepository messageRepository;

	@Override
	public PostDto createPost(NewPostDto newPostDto, String ownerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDto updatePost(NewPostDto newPostDto, String ownerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDto deletePost(String ownerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDto getPostById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<PostDto> viewPosts(int items_on_page, int current_page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void complainOnPost(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hidePost(String id) {
		// TODO Auto-generated method stub
		
	}

}
