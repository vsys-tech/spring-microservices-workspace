package cricket.app.repositories;

import cricket.app.documents.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UsersRepository extends ReactiveMongoRepository<User, String> {
}
