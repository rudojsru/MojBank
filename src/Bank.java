import java.util.ArrayList;
import java.util.List;

public class Bank {

    List<User> users = new ArrayList<>();
    User user1= new User("ss","kkk",123, new Account());
    User user2= new User("ttttt","yyyyyyy",1234, new Account());


    public void getUser (int account){
        users.get(account);
    }




boolean staticUsers;

    public List<User> getUsers() {
        while (!staticUsers){
            users.add(user1);
            users.add(user2);
            staticUsers =true;
        }

        return users;
    }
}
