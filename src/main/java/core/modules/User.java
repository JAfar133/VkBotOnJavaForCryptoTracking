package core.modules;

import java.util.ArrayList;
import java.util.Objects;

public class User {
    private int userId;
    private ArrayList<String> userTickets = new ArrayList<>();

    public User(int userId, ArrayList<String> userTickets) {
        this.userId = userId;
        this.userTickets = userTickets;
    }

    public User(int userId) {
        this.userId=userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public ArrayList<String> getUserTickets() {
        return userTickets;
    }

    public boolean setUserTickets(String tickets) {
        if(!userTickets.contains(tickets)&&userTickets.add(tickets))
            return true;
        else
            return false;
    }
    public boolean delUserTickets(String tickets){
        if(userTickets.remove(tickets))
            return true;
        else
            return false;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId;
    }

    @Override
    public int hashCode() {
        return 7*(new Integer(userId)).hashCode();
    }
}
