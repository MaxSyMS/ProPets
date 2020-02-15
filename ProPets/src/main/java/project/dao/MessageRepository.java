package project.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import project.domain.message.Post;

public interface MessageRepository extends MongoRepository<Post, String> {

}
