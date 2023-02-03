package com.social.media.application.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();
    private static int userCount=0;

    static {
        users.add(new User(++userCount,"Ram", LocalDate.now().minusYears(40)));
        users.add(new User(++userCount,"Sam", LocalDate.now().minusYears(50)));
        users.add(new User(++userCount,"Mack", LocalDate.now().minusYears(30)));
    }

    public List<User> findAll(){
        return users;
    }

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return  users.stream().filter(predicate).findFirst().orElse(null);
    }

    public void deleteById(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }

    public User save(User user){
        user.setId(++userCount);
        users.add(user);
        return user;
    }
}
