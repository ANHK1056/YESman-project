package com.kosa.projectdeveloper.service;

import com.kosa.projectdeveloper.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {
    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String user_id) throws UsernameNotFoundException {
        return userRepository.findById(user_id)
                .orElseThrow(()-> new IllegalArgumentException((user_id)));
    }
}
