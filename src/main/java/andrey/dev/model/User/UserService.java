package andrey.dev.model.User;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private static int concurrentUserId = 1;
    private HashMap<String, User> userMap = new HashMap<>();

    public User createUser(String login) {
        if (!userMap.containsKey(login)) {
            User user = new User(concurrentUserId++, login);
            userMap.put(login, user);
            return user;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public User searchUserByUserId(int userId) {
        for (Map.Entry<String, User> user : userMap.entrySet()) {
            if (userId == user.getValue().getUserId()) {
                return user.getValue();
            }
        }
        throw new IllegalArgumentException();
    }

    public void showAllUsers() {
        System.out.println(userMap);
    }
}
