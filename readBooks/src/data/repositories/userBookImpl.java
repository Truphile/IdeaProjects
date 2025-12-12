package data.repositories;

import data.models.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class userBookImpl implements userBook {
    List<User> userlist = new ArrayList<>();

    int count;

    @Override
    public long count() {
        return userlist.size();
    }

    @Override
    public User save(User user) {
        if(isNew(user)) saveNew(user);
        else updateBook(user);

        return user;
    }

    private void updateBook(User user) {

    }

    private void saveNew(User user) {
        count++;
        user.setId(count);
        userlist.add(user);
    }

    private boolean isNew(User user) {
        return user.getId() == 0;
    }

    @Override
    public User delete(User user) {
        if (userlist.contains(user)) userlist.remove(user);
        return user;
    }

    @Override
    public User findById(int id) {
        for (User user : userlist) {
            if (user.getId() == id) return user;
            }
        return null;
    }

    @Override
    public User deleteById(int id) {
        for (User user : userlist) {
            if (user.getId() == id) return user;
        }
        return null;
    }

    @Override
    public List<User> findAll() {
       return userlist;

    }

    public List<User> deleteAll() {
        userlist.clear();
        return userlist;
    }

    public boolean checkIfBookExists(int id) {
        for (User user : userlist) {
            if (user.getId() == id) return true;
        }
        return false;
    }
}
