package com.nvc.assignment.integration;

import com.nvc.assignment.controller.NvcUserController;
import com.nvc.assignment.data.dao.NvcUserDao;
import com.nvc.assignment.data.repository.INvcUserRepository;
import com.nvc.assignment.domain.pojo.NvcUser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class BusinessIntegrationTest {

    @Autowired
    private INvcUserRepository userRepository;

    @Autowired
    private NvcUserController userController;

    @Test
    void userShouldBeRegistered()
    {
        NvcUser user = NvcUser.builder()
                .firstName("Leandro")
                .lastName("Erazo")
                .email("leorb23@gmail.com").build();

        userController.updateUser(user);

        Optional<NvcUserDao> userDaoOptional = Optional.of(userRepository.findByEmail(user.getEmail()));

        assertTrue(userDaoOptional.isPresent());

    }


}
