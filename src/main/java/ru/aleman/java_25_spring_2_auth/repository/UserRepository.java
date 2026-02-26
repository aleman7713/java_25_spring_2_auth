package ru.aleman.java_25_spring_2_auth.repository;

import org.springframework.stereotype.Component;
import ru.aleman.java_25_spring_2_auth.service.dictionary.Authorities;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository {
    public List<Authorities> getUserAuthorities(String user, String password) {

        List<Authorities> result = new ArrayList<>();

        if ((user.compareTo("admin") == 0) && (password.compareTo("admin") == 0))
        {
            result.add(Authorities.READ);
            result.add(Authorities.WRITE);
            result.add(Authorities.DELETE);
            return  result;
        } else if ((user.compareTo("user_top") == 0) && (password.compareTo("user_top") == 0)) {
            result.add(Authorities.READ);
            result.add(Authorities.WRITE);
            return  result;
        } else if ((user.compareTo("user") == 0) && (password.compareTo("user") == 0)) {
            result.add(Authorities.READ);
            return  result;
        }

        return null;
    }
}