package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.dto.message.NewPostDto;
import project.dto.message.PostDto;
//M
import project.service.message.MessageService;

@RestController
@RequestMapping("{lang}/message/v1")
public class MessageController {
	
	@Autowired
	MessageService messageService;

	@PostMapping("/{ownerId}")
	public PostDto createPost(@RequestBody NewPostDto newPostDto) {
		return messageService.createPost(newPostDto);
	}

}
