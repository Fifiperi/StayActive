package fsre.stayactive.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {
    private User user;

    public UserDetails(User user) {
        this.user = user;
    }

    @Override
    public String getPassword() {
        return user.getLozinka();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getFullName() {
        return user.getIme() + " " + user.getPrezime();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Role singleRole = user.getRole(); // Assuming getRole() returns a single role

        if (singleRole != null) {
            // If the role is not null, return a single SimpleGrantedAuthority
            return Collections.singletonList(new SimpleGrantedAuthority(singleRole.name()));
        } else {
            // If the role is null, return an empty list or handle it according to your requirements
            return Collections.emptyList();
        }
    }
}