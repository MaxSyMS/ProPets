package project.convertor.message;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import project.domain.message.Post;
import project.dto.message.PostDto;
import project.dto.message.ViewPostDto;

@Component
//M
public class MessageConvertor {

	public PostDto convertToPostDto(Post post) {
		return PostDto.builder()
				.id(post.getId())
				.ownerId(post.getOwnerId())
				.postDate(post.getPostDate())
				.text(post.getText())
				.images(post.getImages())
				.build();
	}

	public ViewPostDto convertToViewPostDto(List<PostDto> list, Pageable paging) {
		return ViewPostDto.builder()
				.posts(list)
				.currentPage(paging.getPageNumber())
				.itemsOnPage(paging.getPageSize())
				.itemsTotal(list.size())
				.build();
	}

}
