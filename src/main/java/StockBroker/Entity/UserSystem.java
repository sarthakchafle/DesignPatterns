package StockBroker.Entity;

import java.util.HashMap;
import java.util.Map;

public class UserSystem {
    static Map<String, User> userMap = new HashMap<>();
    public static User addUser(String userId,User user){
        userMap.put(userId,user);
        return userMap.get(userId);
    }
    public static User getUser(String userId){
        return userMap.get(userId);
    }
}
