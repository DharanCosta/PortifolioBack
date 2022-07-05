package com.portifoliodharan.dharanportifolio.security;

import com.portifoliodharan.dharanportifolio.models.UserModel;
import com.portifoliodharan.dharanportifolio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<UserModel> user = userRepository.findByUser(userName);
        user.orElseThrow(()-> new UsernameNotFoundException(userName+" not found."));

        return user.map(UserDetailsImpl::new).get();
    }
}
