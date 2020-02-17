package project.service.message;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import project.convetnor.message.MessageConvertor;
import project.dao.MessageRepository;
import project.domain.message.Post;
import project.dto.message.NewPostDto;
import project.dto.message.PostDto;
import project.dto.message.ViewPostDto;
import project.exseptions.message.PostNotFoundException;


@Service
//M
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
	public ViewPostDto viewPosts(int itemsOnPage, int currentPage) {
		Pageable paging = PageRequest.of(currentPage, itemsOnPage);
		/*
		INFO
		The findAll(Pageable pageable) method by default returns a Page<T> object.
		However, we can choose to return either a Page<T>, a Slice<T> or a List<T> from any of our custom methods returning a paginated data.
		A Page<T> instance, in addition to having the list of Products, also knows about the total number of available pages. 
		It triggers an additional count query to achieve it. To avoid such an overhead cost, we can instead return a Slice<T> or a List<T>.
		A Slice only knows about whether the next slice is available or not.
		https://www.baeldung.com/spring-data-jpa-pagination-sorting
		*/
		Slice<Post> allPostsPageable = messageRepository.findAll(paging);
		List<PostDto> list = allPostsPageable.getContent().stream()
				.map(post->convertor.convertToPostDto(post))
				.collect(Collectors.toList());
		return convertor.convertToViewPostDto(list, paging);	
		
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
