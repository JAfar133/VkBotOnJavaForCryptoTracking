package core.modules;

import java.util.HashMap;
import java.util.HashSet;

public class UserList {
    private HashSet<User> userList;

    public UserList(HashMap<Integer, User> userList) {
        this.userList = new HashSet<>();
    }

    @Override
    public String toString() {
        return "UserList{" +
                "userList=" + userList +
                '}';
    }

    public UserList() {
        userList = new HashSet<>();
    }

    public HashSet<User> getUserMap() {
        return userList;
    }
    public boolean addUser(User u){
        if(userList.add(u))
            return true;
        else
            return false;
    }
    public boolean delUser(User u){
        if(userList.remove(u))
            return true;
        else
            return false;
    }
    public User getUser(int id){
        for (User u:userList)
            if(u.getUserId()==id) return u;
        return null;
    }
}
