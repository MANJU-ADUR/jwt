package com.jwt.service;

import com.jwt.dto.CreateUserDTO;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface UserService {
    ResponseEntity<Map<String, Object>> createUser(CreateUserDTO dto);
}
