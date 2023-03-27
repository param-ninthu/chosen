package dev.chosen.chosen.repo;

import dev.chosen.chosen.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegisterRepository extends MongoRepository<User, String> {
    Optional<User> findUserByUsername(String username);
}
