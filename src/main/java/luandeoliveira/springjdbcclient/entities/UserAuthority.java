package luandeoliveira.springjdbcclient.entities;

import java.util.List;

public record UserAuthority(String username, String password, Boolean enabled, List<String> authorities) {
}
