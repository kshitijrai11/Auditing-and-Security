package com.SecurityApp.SecurityApplication.services;

import com.SecurityApp.SecurityApplication.dto.LoginDto;
import com.SecurityApp.SecurityApplication.dto.SignUpDto;
import com.SecurityApp.SecurityApplication.dto.UserDto;
import com.SecurityApp.SecurityApplication.entities.User;
import com.SecurityApp.SecurityApplication.exceptions.ResourceNotFoundException;
import com.SecurityApp.SecurityApplication.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new ResourceNotFoundException("User with email "+ username +" not found"));
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new BadCredentialsException("User with id "+ userId + " not found"));
    }

    public UserDto signUp(SignUpDto signUpDto) {
        Optional<User> user = userRepository.findByEmail(signUpDto.getEmail());
        if(user.isPresent()) {
            throw new BadCredentialsException("User with email already exists "+ signUpDto.getEmail());
        }

        User toBeCreateedUser = modelMapper.map(signUpDto, User.class);
        toBeCreateedUser.setPassword(passwordEncoder.encode(toBeCreateedUser.getPassword()));
        User savedUser = userRepository.save(toBeCreateedUser);
        return modelMapper.map(savedUser, UserDto.class);
    }

}
