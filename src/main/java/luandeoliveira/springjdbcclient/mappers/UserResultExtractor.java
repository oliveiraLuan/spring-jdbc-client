package luandeoliveira.springjdbcclient.mappers;

import luandeoliveira.springjdbcclient.entities.UserAuthority;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class UserResultExtractor implements ResultSetExtractor<List<UserAuthority>> {
    @Override
    public List<UserAuthority> extractData(ResultSet rs) throws SQLException, DataAccessException {
        Map<String, UserAuthority> users = new LinkedHashMap<>();
        while(rs.next()){
            String username = rs.getString("username");
            UserAuthority user = users.get(username);
            if(user == null){
                user = new UserAuthority(
                        username,
                        rs.getString("password"),
                        rs.getBoolean("enabled"),
                        new ArrayList<>()
                );
                users.put(username, user);
            }
            user
                    .authorities()
                    .add(rs.getString("authority"));
        }
        return new ArrayList<>(users.values());
    }
}
