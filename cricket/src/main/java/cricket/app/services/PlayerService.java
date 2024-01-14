package cricket.app.services;

import cricket.app.documents.Player;
import cricket.app.repositories.PlayerRepository;
import cricket.app.web.form.PlayerForm;
import cricket.app.web.shared.PlayerShared;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<PlayerShared> find() {

        var playerSharedList = new ArrayList<PlayerShared>();
        var playList =
                this.playerRepository.findAll()
                        .log()
                        .toStream()
                        .toList();

        var modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

        for (var player : playList) {
            var playerShared = modelMapper.map(player, PlayerShared.class);
            playerSharedList.add(playerShared);
        }
        return playerSharedList;

    }

    public List<PlayerShared> findByTeamId(String teamId) {

        var playerSharedList = new ArrayList<PlayerShared>();
        var playList =
                this.playerRepository.findPlayersByTeamId(teamId)
                        .log()
                        .toStream()
                        .toList();

        var modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

        for (var player : playList) {
            var playerShared = modelMapper.map(player, PlayerShared.class);
            playerSharedList.add(playerShared);
        }
        return playerSharedList;

    }




    public void insertOne(PlayerForm playerForm) {
        var modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        var player = modelMapper.map(playerForm, Player.class);
        this.playerRepository.save(player).subscribe();
    }


    public void updateOne(PlayerForm playerForm) {
        var modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        var player = modelMapper.map(playerForm, Player.class);
        this.playerRepository.save(player).subscribe();
    }

    public void deleteOne(PlayerForm playerForm) {
        var modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        var player = modelMapper.map(playerForm, Player.class);
        this.playerRepository.delete(player).subscribe();
    }


}
