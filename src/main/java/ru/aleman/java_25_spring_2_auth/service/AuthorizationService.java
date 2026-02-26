package ru.aleman.java_25_spring_2_auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.aleman.java_25_spring_2_auth.exception.InvalidCredentials;
import ru.aleman.java_25_spring_2_auth.exception.UnauthorizedUser;
import ru.aleman.java_25_spring_2_auth.repository.UserRepository;
import ru.aleman.java_25_spring_2_auth.repository.model.User;
import ru.aleman.java_25_spring_2_auth.service.dictionary.Authorities;

import java.util.List;

@Component
public class AuthorizationService {
    @Autowired
    private UserRepository userRepository;

    //    public AuthorizationService(UserRepository userRepository) {
    //    this.userRepository = userRepository;
    //}

    public List<Authorities> getAuthorities(User user) {
        return getAuthorities(user.getUser(), user.getPassword());
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}