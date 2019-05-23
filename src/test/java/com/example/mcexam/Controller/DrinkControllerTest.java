package com.example.mcexam.Controller;
import com.example.mcexam.model.Drink;
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
public class DrinkControllerTest
{
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void application_returns_array_of_drinks()
    {
        ResponseEntity<Drink[]> response = restTemplate.getForEntity("/drink",Drink[].class);
        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertNotEquals(0,response.getBody().length);
    }

    @Test
    public void you_can_find_drink_by_id()
    {
        ResponseEntity<Drink> response = restTemplate.getForEntity("/drink/4",Drink.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Coke",response.getBody().getName());
    }

}
