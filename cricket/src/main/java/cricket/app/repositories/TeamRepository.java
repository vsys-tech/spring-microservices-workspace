package cricket.app.repositories;

import cricket.app.documents.Team;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TeamRepository extends ReactiveMongoRepository<Team,String> {
}
