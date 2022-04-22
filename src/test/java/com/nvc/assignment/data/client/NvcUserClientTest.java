package com.nvc.assignment.data.client;

import com.nvc.assignment.data.dao.NvcUserDao;
import com.nvc.assignment.data.repository.INvcUserRepository;
import com.nvc.assignment.domain.pojo.NvcUser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class NvcUserClientTest {

    @InjectMocks
    private NvcUserClient userClient;

    @Mock
    private INvcUserRepository userRepository;

    @Test
    void itShouldGetAllUsers()
    {
        NvcUserDao user = NvcUserDao.builder()
                .firstName("Leandro")
                .lastName("Erazo")
                .email("leorb23@gmail.com").build();

        List<NvcUserDao> userDaoList = new ArrayList<>();

        when(userRepository.findAll()).thenReturn(userDaoList);

        List<NvcUser> result = userClient.getAllUsers();

        assertTrue(result.isEmpty());


        userDaoList.add(user);

        when(userRepository.findAll()).thenReturn(userDaoList);

        result = userClient.getAllUsers();

        assertFalse(result.isEmpty());

    }

    @Test
    void itShouldUpdateUser()
    {
        NvcUser user = NvcUser.builder()
                .firstName("Leandro")
                .lastName("Erazo")
                .email("leorb23@gmail.com").build();

        when(userRepository.findByEmail(anyString())).thenReturn(mock(NvcUserDao.class));

        when(userRepository.save(any())).thenReturn(mock(NvcUserDao.class));

        assertDoesNotThrow(() -> userClient.saveUser(user));


        when(userRepository.findByEmail(anyString())).thenReturn(null);

        when(userRepository.save(any())).thenReturn(mock(NvcUserDao.class));

        assertDoesNotThrow(() -> userClient.saveUser(user));
    }

}
