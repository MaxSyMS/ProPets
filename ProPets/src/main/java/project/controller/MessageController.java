package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.dto.message.NewPostDto;
import project.dto.message.PostDto;
//M
import project.service.message.MessageService;

@RestController
@RequestMapping("/{lang}/message/v1")
//M
public class MessageController {
	
	@Autowired
	MessageService messageService;

	@PostMapping("/{ownerId}")
	public PostDto createPost(@RequestBody NewPostDto newPostDto, @PathVariable String ownerId) {
		return messageService.createPost(newPostDto, ownerId);
	}
	
	@PutMapping("/{ownerId}")
	public PostDto updatePost(@RequestBody NewPostDto newPostDto, @PathVariable String ownerId) {
		return messageService.updatePost(newPostDto, ownerId);
	}
	
	@DeleteMapping("/{ownerId}")
	public PostDto deletePost(@PathVariable String ownerId) {
		return messageService.deletePost(ownerId);
	}
	
	@GetMapping("/{id}")
	public PostDto getPostById(@PathVariable String id) {
		return messageService.getPostById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
