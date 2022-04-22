package com.nvc.assignment.domain.service;

import com.nvc.assignment.data.client.NvcUserClient;
import com.nvc.assignment.domain.pojo.NvcUser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class NvcUserServiceTest {

    @InjectMocks
    private NvcUserService userService;

    @Mock
    private NvcUserClient userClient;

    @Test
    void itShouldGetAllUsers()
    {
        when(userClient.getAllUsers()).thenReturn(mock(ArrayList.class));
        assertDoesNotThrow(()-> userService.getAllUsers());
    }

    @Test
    void itShouldUpdateUser()
    {
        doNothing().when(userClient).saveUser(any(NvcUser.class));
        assertDoesNotThrow(()-> userService.updateUser(mock(NvcUser.class)));
    }

    @Test
    void itShouldFindByEmail()
    {
        when(userClient.findByEmail(anyString())).thenReturn(true);
        assertDoesNotThrow(()-> userService.findByEmail(anyString()));
    }

}
