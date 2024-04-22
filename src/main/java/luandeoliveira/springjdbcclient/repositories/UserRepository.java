package luandeoliveira.springjdbcclient.repositories;

import luandeoliveira.springjdbcclient.entities.User;
import luandeoliveira.springjdbcclient.repositories.constants.UserConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;
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
}
