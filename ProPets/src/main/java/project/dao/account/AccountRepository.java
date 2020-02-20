package project.dao.account;

import org.springframework.data.mongodb.repository.MongoRepository;

import project.domain.account.User;

public interface AccountRepository extends MongoRepository<User, String> {

}
