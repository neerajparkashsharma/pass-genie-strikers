//package com.project.passgenie.controller;
//
//import com.project.passgenie.dto.LoginRequest;
//import com.project.passgenie.dto.RegisterRequest;
//import com.project.passgenie.entity.User;
//import com.project.passgenie.security.JwtUtil;
//import com.project.passgenie.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//
////import javax.validation.Valid;
//
//@RestController
//@RequestMapping("/api/accounts")
//public class AccountController {
//
//    private final UserService userService;
//    private final PasswordEncoder passwordEncoder;
//    private final AuthenticationManager authenticationManager;
//    private final JwtUtil jwtUtil;
//    private final UserDetailsService userDetailsService;
//
//    @Autowired
//    public AccountController(UserService userService,
//                             PasswordEncoder passwordEncoder,
//                             AuthenticationManager authenticationManager,
//                             JwtUtil jwtUtil,
//                             UserDetailsService userDetailsService) {
//        this.userService = userService;
//        this.passwordEncoder = passwordEncoder;
//        this.authenticationManager = authenticationManager;
//        this.jwtUtil = jwtUtil;
//        this.userDetailsService = userDetailsService;
//    }
//
//    @PostMapping("/register")
//    public ResponseEntity<?> register(@RequestBody   RegisterRequest registerRequest) {
//        if (userService.findByUsername(registerRequest.getUsername()) != null) {
//            return ResponseEntity.status(HttpStatus.CONFLICT).build();
//        }
//
//        User user = new User();
//        user.setUsername(registerRequest.getUsername());
//        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
//        userService.createUser(user);
//        return ResponseEntity.ok().build();
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody  LoginRequest loginRequest) {
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
//                    loginRequest.getPassword()));
//
//        } catch (AuthenticationException e) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//
//        UserDetails userDetails;
//        try {
//            userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());
//        } catch (UsernameNotFoundException e) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//
//        String jwtToken = jwtUtil.generateToken(userDetails);
//        return ResponseEntity.ok(jwtToken);
//    }
//}