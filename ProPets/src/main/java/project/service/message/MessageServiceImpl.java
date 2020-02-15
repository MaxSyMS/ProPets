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

}
