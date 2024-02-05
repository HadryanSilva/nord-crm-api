package br.com.nord.nordcrmapi.service;

import br.com.nord.nordcrmapi.exception.NotFoundException;
import br.com.nord.nordcrmapi.mapper.UserMapper;
import br.com.nord.nordcrmapi.mapper.request.user.UserPostRequest;
import br.com.nord.nordcrmapi.mapper.request.user.UserPutRequest;
import br.com.nord.nordcrmapi.model.User;
import br.com.nord.nordcrmapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper;

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }

    public User save(UserPostRequest request) {
        log.info("Saving user");
        var userToSave = mapper.postToUser(request);
        return userRepository.save(userToSave);
    }

    public void delete(Long id) {
        var userToDelete = findById(id);
        log.info("Deleting user with id {}", id);
        userRepository.delete(userToDelete);
        log.info("User with id {} deleted successfully", id);
    }

    public void update(UserPutRequest request) {
        log.info("Updating user with id {}", request.getId());
        var userToUpdate = mapper.putToUser(request);
        assertUserExists(userToUpdate);
        userRepository.save(userToUpdate);
        log.info("User updated successfully");
    }

    private void assertUserExists(User user) {
        findById(user.getId());
    }

}
