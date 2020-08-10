package main.shop.Service;

import main.shop.Model.Role;
import main.shop.Model.User;
import main.shop.Repository.RoleRepository;
import main.shop.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private static final String DEFAULT_ROLE = "Client";
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    List<Role> roles = new ArrayList<>();

    @Autowired
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void addWithDefaultRole(User user){
        roles.add(new Role("Client"));
        roles.add(new Role("Admin"));
        roles.forEach(roleRepository::save);
        Role defaultRole = roleRepository.findByRoleName(DEFAULT_ROLE);
        user.setRole(defaultRole);
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        userRepository.save(user);
    }
}
