package com.example.mcexam.Controller;

import com.example.mcexam.model.Burger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BurgerControllerTest
{
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void application_returns_array_of_burgers()
    {
        ResponseEntity<Burger[]> response = restTemplate.getForEntity("/burger",Burger[].class);
        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertNotEquals(0,response.getBody().length);
    }
}
