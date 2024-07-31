package br.com.nord.api.service;

import br.com.nord.api.exception.NotFoundException;
import br.com.nord.api.mapper.UserMapper;
import br.com.nord.api.mapper.request.user.UserPostRequest;
import br.com.nord.api.mapper.response.user.UserGetResponse;
import br.com.nord.api.mapper.response.user.UserPostResponse;
import br.com.nord.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Log4j2
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder encoder;

    public List<UserGetResponse> findAll(int page, int size) {
        log.info("Finding all users");
        return userRepository.findAll(PageRequest.of(page, size)).getContent()
                .stream()
                .map(userMapper::userToGetResponse)
                .toList();
    }

    public UserGetResponse findById(Long id) {
        log.info("Finding user with id: {}", id);
        var userFound = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));
        return userMapper.userToGetResponse(userFound);
    }

    public UserPostResponse save(UserPostRequest request) {
        log.info("Saving user: {}", request);
        var userToSave = userMapper.postToUser(request);
        userToSave.setPassword(encoder.encode(request.getPassword()));
        var user = userRepository.save(userToSave);
        return userMapper.userToPostResponse(user);
    }

    public void delete(Long id) {
        log.info("Deleting user with id: {}", id);
        userRepository.deleteById(id);
    }

    public void update(Long id, UserPostRequest request) {
        log.info("Updating user with id: {}", id);
        var user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        userRepository.save(user);
    }

}
