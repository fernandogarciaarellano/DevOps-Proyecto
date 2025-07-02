package mx.com.example.web.rest;

import mx.com.example.commons.to.UserTO;
import mx.com.example.web.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class HelloControllerTest extends BaseTest {

    //@Test
    public void exampleTest() {

        //this.entityManager.persist(new UserDO("Javier", "Rodriguez", 1));

        List<UserTO> users = this.microservicioFacade.getAllUsers();

        Assertions.assertNotNull(users);
        Assertions.assertEquals(2, users.size());
    }
}
