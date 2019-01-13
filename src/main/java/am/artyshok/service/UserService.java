package am.artyshok.service;

import am.artyshok.dto.User;
import am.artyshok.entity.UserEntity;
import am.artyshok.mapper.UserMapper;
import am.artyshok.repository.UserRepository;
import am.artyshok.security.config.BCryptConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BCryptConfiguration bCryptConfiguration;

    public UserService(UserRepository userRepository, UserMapper userMapper, BCryptConfiguration bCryptConfiguration) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.bCryptConfiguration = bCryptConfiguration;
    }


    public User createUser(User user) {
        UserEntity userEntity = userMapper.map(user);

        userEntity.setPassword(
                bCryptConfiguration.passwordEncoder().encode(userEntity.getPassword()));

        UserEntity createdUser = userRepository.save(userEntity);
        return userMapper.map(createdUser);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.getByEmail(email);
        return userMapper.mapToPrincipal(userEntity);
    }

}
