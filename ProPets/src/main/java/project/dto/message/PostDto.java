package project.dto.message;

import java.time.LocalDateTime;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
//M
public class PostDto {

	int id;
	String ownerId;
	LocalDateTime postDate;
	String text;
	Set<String> images;
	// FIXME
	// set polzovateley a ne stringov
	Set<String> blackList;

}
