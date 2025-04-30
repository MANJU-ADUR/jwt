package com.jwt.service.impl;

import com.jwt.dto.CreateUserDTO;
import com.jwt.entity.User;
import com.jwt.repository.UserRepository;
import com.jwt.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    //    @Autowired
    private UserRepository userRepository;

    private ModelMapper modelMapper;

    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ResponseEntity<Map<String, Object>> createUser(CreateUserDTO dto) {
        try {
            User user = modelMapper.map(dto, User.class);
            user.setPassword(passwordEncoder.encode(dto.getPassword()));
            userRepository.save(user);
            return new ResponseEntity<>(Map.of("message", "User Registered", "status", HttpStatus.OK.value()), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
