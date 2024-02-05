package br.com.nord.nordcrmapi.service;

import br.com.nord.nordcrmapi.mapper.UserMapper;
import br.com.nord.nordcrmapi.mapper.request.UserPostRequest;
import br.com.nord.nordcrmapi.mapper.request.UserPutRequest;
import br.com.nord.nordcrmapi.model.User;
import br.com.nord.nordcrmapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper;

    public User save(UserPostRequest request) {
        log.info("Saving user");
        var userToSave = mapper.postToUser(request);
        return userRepository.save(userToSave);
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    public void delete(Long id) {
        findById(id);
        log.info("Deleting user with id {}", id);
        userRepository.deleteById(id);
    }

    public void update(UserPutRequest request) {
        findById(request.getId());
        log.info("Updating user with id {}", request.getId());
        var userToUpdate = mapper.putToUser(request);
        userRepository.save(userToUpdate);
    }

}
