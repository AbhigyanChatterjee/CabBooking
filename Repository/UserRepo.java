package Repository;

import java.util.HashMap;
import java.util.Map;

import Model.User;

public class UserRepo {
    private static UserRepo userRepo = new UserRepo();
    private Map<String, User> allUsers;
    
    
    private UserRepo() {
        allUsers = new HashMap<String, User>();
    }

    public static UserRepo makeUserRepo(){
        return userRepo;
    }

    public void addUser(User user) {
        allUsers.put(user.getUserId(), user);
    }

    public User getUserById(String userId) {
        if(!allUsers.containsKey(userId)) {
            System.out.println("User is not present");
            return null;
        }
        return allUsers.get(userId);
    }

    
}
