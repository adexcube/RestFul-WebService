package edu.miu.cs.cs544.controller;


import edu.miu.cs.cs544.domain.User;
import edu.miu.cs.cs544.service.LoginService;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.SecondaryTable;
import java.security.Security;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;


    @GetMapping
    public ResponseEntity<User> login(@RequestParam("username") String username, @RequestParam("password") String password){
        try {
            User user = loginService.login(username, password);
            if(user != null) {
                return ResponseEntity.ok().body(user);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
        }
    }

}
