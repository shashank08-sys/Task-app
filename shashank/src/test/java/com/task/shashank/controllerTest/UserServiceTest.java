package com.task.shashank.controllerTest;

import com.task.shashank.model.Users;
import com.task.shashank.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;

   @Test
    public void testAddition(){
       int a = 2;
       int b = 2;
       Assertions.assertEquals(4, a+b);
    }

    @Test
    public void isUserPresent() {
        String id = "2";
        Users mockUser = new Users();
        mockUser.setId(id);
        Optional<Users> expectedUser = Optional.of(mockUser);

        Mockito.when(userRepository.findById(id)).thenReturn(expectedUser);

        Optional<Users> actualUser = userRepository.findById(id);

        Assertions.assertTrue(actualUser.isPresent());
        Assertions.assertEquals(id, actualUser.get().getId());
    }
}
