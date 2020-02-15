package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@PutMapping("/{id}")
	public PostDto updatePost(@RequestBody NewPostDto newPostDto, @PathVariable String id) {
		return messageService.updatePost(newPostDto, id);
	}

	@DeleteMapping("/{id}")
	public PostDto deletePost(@PathVariable String id) {
		return messageService.deletePost(id);
	}

	@GetMapping("/{id}")
	public PostDto getPostById(@PathVariable String id) {
		return messageService.getPostById(id);
	}

	@GetMapping("/view")
	public Iterable<PostDto> viewPosts(@RequestParam int items_on_page, @RequestParam int current_page) {
		return messageService.viewPosts(items_on_page, current_page);
	}
	
	@PutMapping("/complain")
	public void complainOnPost(@PathVariable String id) {
		messageService.complainOnPost(id);
	}
	
	@PutMapping("/hide")
	public void hidePost(@PathVariable String id) {
		messageService.hidePost(id);
	}
	

}
