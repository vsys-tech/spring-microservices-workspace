package cricket.app.services;

import cricket.app.documents.Team;
import cricket.app.repositories.TeamRepository;
import cricket.app.web.form.TeamForm;
import cricket.app.web.shared.TeamShared;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<TeamShared> find() {
        var modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

        var teamSharedList = new ArrayList<TeamShared>();
        var list1 =
                this.teamRepository.findAll()
                        .log()
                        .toStream()
                        .toList();

        for (var team : list1) {
            var teamShared = modelMapper.map(team, TeamShared.class);
            teamSharedList.add(teamShared);
        }
        return teamSharedList;
    }

    public void insertOne(TeamForm teamForm) {
        var modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        var team = modelMapper.map(teamForm, Team.class);
        this.teamRepository.save(team).subscribe();
    }

    public void updateOne(TeamForm teamForm) {
        var modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        var team = modelMapper.map(teamForm, Team.class);
        this.teamRepository.save(team).subscribe();
    }

    public void deleteOne(TeamForm teamForm) {
        var modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        var team = modelMapper.map(teamForm, Team.class);
        this.teamRepository.delete(team).subscribe();
    }

}
