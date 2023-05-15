package hr.tvz.santro.studapp.service;

import hr.tvz.santro.studapp.domain.User;
import hr.tvz.santro.studapp.dto.UserDTO;
import hr.tvz.santro.studapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public Optional<UserDTO> findByUsername(String username) {
        return this.userRepository.findOneByUsername(username).map(this::mapToDTO);
    }

    private UserDTO mapToDTO(User user){
        return new UserDTO(user.getId(), user.getUsername(), user.getFirst_name(), user.getLast_name(), user.getAuthoritiesToString());
    }
}
