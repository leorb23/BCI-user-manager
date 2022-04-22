package com.nvc.assignment.data.client;

import com.nvc.assignment.data.dao.NvcUserDao;
import com.nvc.assignment.data.repository.INvcUserRepository;
import com.nvc.assignment.domain.pojo.NvcUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class NvcUserClient {

    @Autowired
    private INvcUserRepository nvcUserRepository;

    public void saveUser(NvcUser user)
    {
        log.info("Convert user into userDao and Saving it into db. User: {}", user.toString());
        if(!findByEmail(user.getEmail()))
        {
            NvcUserDao userDao = NvcUserDao.builder()
                    .email(user.getEmail())
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName()).build();
            log.info("Saving user into db. User: {}", user.toString());
            nvcUserRepository.save(userDao);
        }
        else
        {
            NvcUserDao userDao = nvcUserRepository.findByEmail(user.getEmail());
            userDao.setFirstName(user.getFirstName());
            userDao.setLastName(user.getLastName());
            log.info("Updating user into db. User: {}", user.toString());
            nvcUserRepository.save(userDao);
        }
        log.info("Event saved successfully");
    }

    public List<NvcUser> getAllUsers()
    {
        log.info("In client getAllUsers() ");
        List<NvcUserDao> userDaoList = nvcUserRepository.findAll();
        List<NvcUser> userList = new ArrayList<>();
        if(!userDaoList.isEmpty())
        {
            userDaoList.stream().forEach(u ->
            {
                NvcUser user = NvcUser.builder()
                        .email(u.getEmail())
                        .firstName(u.getFirstName())
                        .lastName(u.getLastName()).build();
                userList.add(user);
            });
        }

        return userList;
    }

    public Boolean findByEmail(String email)
    {
        Boolean exist = false;
        NvcUserDao userDao = nvcUserRepository.findByEmail(email);
        if(!Objects.isNull(userDao))
        {
            exist = true;
        }

        return exist;
    }
}
