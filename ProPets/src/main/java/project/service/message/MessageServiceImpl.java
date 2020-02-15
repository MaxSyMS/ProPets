package project.service.message;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.convetnor.message.MessageConvertor;
import project.dao.MessageRepository;
import project.domain.message.Post;
import project.dto.message.NewPostDto;
import project.dto.message.PostDto;
import project.exseptions.message.PostNotFoundException;


@Service
//m
public class MessageServiceImpl implements MessageService {
	@Autowired
	MessageRepository messageRepository;
	@Autowired
	MessageConvertor convertor;

	@Override
	public PostDto createPost(NewPostDto newPostDto, String ownerId) {
		Post post = Post.builder()
			.ownerId(ownerId)
			.postDate(LocalDateTime.now())
			.text(newPostDto.getText())
			.blackList(new HashSet<String>())
			.images(checkImages(newPostDto.getImages()))
			.complpain(false)
			.build();
		post = messageRepository.save(post);
		return convertor.convertToPostDto(post);
	}
	
	Set<String> checkImages(Set<String> images){
		if (images != null) {
			return images;
		}else {
			return new HashSet<String>();
		}	
	}

	@Override
	public PostDto updatePost(NewPostDto newPostDto, String id) {
		Post post = messageRepository.findById(id).orElseThrow(PostNotFoundException::new);
		if(newPostDto.getText()!=null) {
			post.setText(newPostDto.getText());
		}
		if(newPostDto.getImages()!=null) {
			newPostDto.getImages().forEach(post::addImages);;
		}
		messageRepository.save(post);
		return convertor.convertToPostDto(post);
	}

	@Override
	public PostDto deletePost(String id) {
		Post post = messageRepository.findById(id).orElseThrow(PostNotFoundException::new);
		messageRepository.delete(post);
		return convertor.convertToPostDto(post);
	}

	@Override
	public PostDto getPostById(String id) {
		Post post = messageRepository.findById(id).orElseThrow(PostNotFoundException::new);
		return convertor.convertToPostDto(post);
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
