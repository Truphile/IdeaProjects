package data.repositories;

import data.models.User;

import java.util.ArrayList;
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
}
