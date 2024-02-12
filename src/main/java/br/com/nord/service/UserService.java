package br.com.nord.service;

import br.com.nord.exception.NotFoundException;
import br.com.nord.model.User;
import br.com.nord.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserService {

    private final UserRepository userRepository;

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }

    public User save(User user) {
        log.info("Saving user");
        return userRepository.save(user);
    }

    public void delete(Long id) {
        var userToDelete = findById(id);
        log.info("Deleting user with id {}", id);
        userRepository.delete(userToDelete);
        log.info("User with id {} deleted successfully", id);
    }

    public void update(User partialUserToUpdate) {
        log.info("Updating user with id {}", partialUserToUpdate.getId());
        var savedUser = findById(partialUserToUpdate.getId());
        assertUserExists(partialUserToUpdate);

        var password = partialUserToUpdate.getPassword() == null ? savedUser.getPassword() : partialUserToUpdate.getPassword();
        var roles = savedUser.getRoles();

        var userToUpdate = partialUserToUpdate.withRoles(roles).withPassword(password);

        userRepository.save(userToUpdate);
        log.info("User updated successfully");
    }

    private void assertUserExists(User user) {
        findById(user.getId());
    }

}
