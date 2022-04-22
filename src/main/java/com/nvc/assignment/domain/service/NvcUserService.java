package com.nvc.assignment.domain.service;

import com.nvc.assignment.data.client.NvcUserClient;
import com.nvc.assignment.domain.pojo.NvcUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class NvcUserService {

    @Autowired
    private NvcUserClient userClient;

    public void updateUser(NvcUser user)
    {
        log.info("In updateUser() for user: {}", user);
        userClient.saveUser(user);
    }

    public List<NvcUser> getAllUsers()
    {
        log.info("In service getAllUsers() ");
        return userClient.getAllUsers();
    }

    public Boolean findByEmail(String email)
    {
        log.info("In service findByEmail() ");
        return userClient.findByEmail(email);
    }

}
