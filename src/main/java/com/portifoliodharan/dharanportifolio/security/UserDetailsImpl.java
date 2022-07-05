package com.portifoliodharan.dharanportifolio.security;

import com.portifoliodharan.dharanportifolio.models.UserModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserDetailsImpl implements UserDetails {

    private static final long serialVersionUID =1L;

    private String user;
    private String password;

    private List<GrantedAuthority> authoroties;

    public UserDetailsImpl(UserModel user) {
        this.user = user.getUser();
        this.password = user.getPassword();
    }

    public UserDetailsImpl(){}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authoroties;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return user;
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
}
