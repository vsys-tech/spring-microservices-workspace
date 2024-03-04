package cricket.app.services;

import cricket.app.repositories.UsersRepository;
import cricket.app.web.shared.UserShared;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<UserShared> find() {

        var userSharedList = new ArrayList<UserShared>();
        var usersList =
                this.usersRepository.findAll()
                        .log()
                        .toStream()
                        .toList();

        var modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

        for (var user : usersList) {
            var userShared = modelMapper.map(user, UserShared.class);
            userSharedList.add(userShared);
        }
        return userSharedList;

    }

}
