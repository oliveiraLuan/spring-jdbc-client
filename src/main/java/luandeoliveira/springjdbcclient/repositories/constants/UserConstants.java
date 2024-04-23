package luandeoliveira.springjdbcclient.repositories.constants;

public class UserConstants {
    public static final String SQL_FIND_ALL_USERS = "SELECT users.username, users.password, users.enabled FROM Users;";
    public static final String SQL_FIND_ALL_USERS_AUTHORITY = "SELECT users.username, users.password, users.enabled, authorities.authority FROM AUTHORITIES LEFT JOIN USERS ON users.username = authorities.username;";
}
