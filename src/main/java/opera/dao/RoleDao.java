package opera.dao;

import java.util.Optional;
import opera.model.Role;

public interface RoleDao {
    Role add(Role role);

    Optional<Role> getRoleByName(Role.RoleName roleName);
}
