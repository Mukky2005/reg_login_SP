package com.example.auth.appuser;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {
    private final static String USER_NOT_FOUND_MSG = "user with email %s not found";
    private final AppUserReop appUserReop;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserReop.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException(
                        String.format(USER_NOT_FOUND_MSG, email)));
    }
}
