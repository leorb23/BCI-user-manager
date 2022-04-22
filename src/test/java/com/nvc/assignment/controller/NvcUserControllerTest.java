package com.nvc.assignment.controller;

import com.nvc.assignment.domain.pojo.NvcUser;
import com.nvc.assignment.domain.service.NvcUserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class NvcUserControllerTest {

    @InjectMocks
    private NvcUserController userController;

    @Mock
    private NvcUserService userService;

    @Test
    void itShouldGetAllUsers()
    {
        List<NvcUser> userList = new ArrayList<>();

        when(userService.getAllUsers()).thenReturn(userList);

        HttpStatus httpStatus = userController.getAllUsers().getStatusCode();

        assertEquals(HttpStatus.NO_CONTENT, httpStatus);

        NvcUser user = NvcUser.builder()
                .firstName("Leandro")
                .lastName("Erazo")
                .email("leorb23@gmail.com").build();

        userList.add(user);

        when(userService.getAllUsers()).thenReturn(userList);

        httpStatus = userController.getAllUsers().getStatusCode();

        assertEquals(HttpStatus.OK, httpStatus);
    }

    @Test
    void itShouldUpdateUser()
    {
        doNothing().when(userService).updateUser(any());
        HttpStatus httpStatus = userController.updateUser(mock(NvcUser.class)).getStatusCode();
        assertEquals(HttpStatus.OK, httpStatus);
    }

    @Test
    void itShouldFindByEmail()
    {
        when(userService.findByEmail(anyString())).thenReturn(false);

        HttpStatus httpStatus = userController.findByEmail(anyString()).getStatusCode();

        assertEquals(HttpStatus.NOT_FOUND, httpStatus);



        when(userService.findByEmail(anyString())).thenReturn(true);

        httpStatus = userController.findByEmail(anyString()).getStatusCode();

        assertEquals(HttpStatus.OK, httpStatus);
    }

}
