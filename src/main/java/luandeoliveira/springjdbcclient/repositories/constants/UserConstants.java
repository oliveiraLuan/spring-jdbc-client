package luandeoliveira.springjdbcclient.repositories.constants;

public class UserConstants {
    public static final String SQL_FIND_ALL_USERS = "SELECT users.username, users.password, users.enabled FROM Users;";
}
