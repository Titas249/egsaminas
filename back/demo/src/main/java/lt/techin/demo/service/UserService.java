package lt.techin.demo.service;

import lt.techin.demo.model.User;
import lt.techin.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

    @Service
    public class UserService {

        private final UserRepository userRepository;

        @Autowired
        public UserService(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

        public User saveUser(User user) {
            return userRepository.save(user);
        }

        public Optional<User> findUserByUsername(String username) {
            return userRepository.findByUsername(username);
        }

        public List<User> findAllUsers() {
            return userRepository.findAll();
        }

        public boolean isUsernameTaken(String username) {
            return userRepository.existsByUsername(username);
        }

        public boolean existsUserById(long id) {
            return userRepository.existsById(id);
        }

        public void deleteUserById(long id) {
            userRepository.deleteById(id);
        }

        public Optional<User> findUserById(long id) {
            return userRepository.findById(id);
        }
    }
