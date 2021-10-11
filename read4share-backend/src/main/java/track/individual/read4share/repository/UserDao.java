package track.individual.read4share.repository;

import track.individual.read4share.model.User;

public interface UserDao {
    void AddUser(User user);
    User GetUser(String username);
    void DeleteUser(String username);
}