package Repository;

import Repository.crud.UserRepository;
import Repository.users.User;

import java.sql.Array;
import java.sql.SQLException;

public class Ranner {
    public static void main(String[] args) throws SQLException {

        UserRepository userRepository = new UserRepository();
//        User user1 = new User("sold5", "john_doe5", 32);
//        User user2 = new User("sold2", "john_doe2", 32);
//        User user3 = new User("sold3", "john_doe3", 32);
        User user1 = new User("canya", "canyaSK", 232);
        userRepository.createUser(user1);
//        userRepository.createUser(user2);
//        userRepository.createUser(user3);
//        userRepository.createUser(user4);
        System.out.println(userRepository.getAllUsers());

//        userRepository.deleteUser(1);
//        userRepository.deleteUser(2);
//        userRepository.deleteUser(3);
//        userRepository.deleteUser(4);
//        userRepository.deleteUser(5);
//        userRepository.deleteUser(3);
//        userRepository.deleteUser(0);
//User kel= userRepository.getUserById(2);
//        System.out.println(kel= userRepository.getUserById(222) );
//        userRepository.updateUserLogin(2,"OLEGGGGG");
        userRepository.close();
    }
}
