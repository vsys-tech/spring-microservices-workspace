package cricket.app.repositories;

import cricket.app.documents.Player;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends ReactiveMongoRepository<Player, String> {
    Flux<Player> findPlayersByTeamId(String teamId);

}
