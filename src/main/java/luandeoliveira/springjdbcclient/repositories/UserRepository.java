package luandeoliveira.springjdbcclient.repositories;

import luandeoliveira.springjdbcclient.entities.User;
import luandeoliveira.springjdbcclient.entities.UserAuthority;
import luandeoliveira.springjdbcclient.mappers.UserResultExtractor;
import luandeoliveira.springjdbcclient.repositories.constants.UserConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    @Autowired
    private JdbcClient jdbcClient;

    public List<User> findAll() {
        return jdbcClient.sql(UserConstants.SQL_FIND_ALL_USERS)
                .query(User.class)
                .list();
    }

    public List<UserAuthority> findAllUsersAuthority(){
        return jdbcClient.sql(UserConstants.SQL_FIND_ALL_USERS_AUTHORITY)
                .query(new UserResultExtractor());
    }

    public User findByUsername(String username) {
        return jdbcClient.sql(UserConstants.SQL_FIND_USER_BY_USERNAME)
                .param(username)
                .query(User.class)
                .single();
    }

    public void deleteByUsername(String username) {
        Integer updated = jdbcClient
                .sql(UserConstants.SQL_DELETE_USER_BY_USERNAME)
                .param(username).update();
        if(updated == 0){
            throw new RuntimeException("User not found!");
        }
    }
}
