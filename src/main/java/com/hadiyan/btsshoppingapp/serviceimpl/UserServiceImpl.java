package com.hadiyan.btsshoppingapp.serviceimpl;

import com.hadiyan.btsshoppingapp.dto.AuthDto;
import com.hadiyan.btsshoppingapp.dto.LoginDto;
import com.hadiyan.btsshoppingapp.dto.UserDto;
import com.hadiyan.btsshoppingapp.model.User;
import com.hadiyan.btsshoppingapp.repository.UserRepository;
import com.hadiyan.btsshoppingapp.util.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import com.hadiyan.btsshoppingapp.service.UserService;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImpl userDetailsService;
    private final JwtUtil jwtTokenUtil;

    public UserServiceImpl(UserRepository userRepository, AuthenticationManager authenticationManager, UserDetailsServiceImpl userDetailsService, JwtUtil jwtTokenUtil) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    public UserDto register(UserDto dto) {
        User user = dto.getUser();
        userRepository.save(user);
        return dto;
    }

    @Override
    public Object login(LoginDto dto) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword())
            );
            final UserDetails userDetails = userDetailsService
                    .loadUserByUsername(dto.getEmail());

            final String jwt = jwtTokenUtil.generateToken(userDetails);
            AuthDto response = new AuthDto();
            response.setToken(jwt);
            return response;
        }
        catch (BadCredentialsException e) {
            return ("Incorrect email or password");
        }
    }
}
