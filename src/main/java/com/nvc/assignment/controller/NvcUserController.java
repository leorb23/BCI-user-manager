package com.nvc.assignment.controller;

import com.nvc.assignment.domain.pojo.NvcUser;
import com.nvc.assignment.domain.service.NvcUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/users")
public class NvcUserController {

    @Autowired
    private NvcUserService userService;


    @PatchMapping(path = "/")
    public ResponseEntity<String> updateUser(@RequestBody @Validated NvcUser userRequest)
    {
        userService.updateUser(userRequest);
        return new ResponseEntity<String>("User added", HttpStatus.OK);
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<NvcUser>> getAllUsers()
    {
        List<NvcUser> userList = userService.getAllUsers();
        if(userList.isEmpty())
        {
            return new ResponseEntity<>(userList, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping(path = "/{email}")
    public ResponseEntity<String> findByEmail(@PathVariable("email") String email)
    {
        Boolean exist = userService.findByEmail(email);
        if(exist)
        {
            return new ResponseEntity<>("User exists", HttpStatus.OK);
        }
        return new ResponseEntity<>("User was not found", HttpStatus.NOT_FOUND);
    }

}
