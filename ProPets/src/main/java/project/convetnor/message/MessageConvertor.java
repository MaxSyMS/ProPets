package project.convetnor.message;

import org.springframework.stereotype.Component;

import project.domain.message.Post;
import project.dto.message.PostDto;

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

}
