package com.example.mcexam.Controller;
import com.example.mcexam.model.Accessory;
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
public class AccessoryControllerTest
{
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void application_returns_array_of_accesories()
    {
        ResponseEntity<Accessory[]> response = restTemplate.getForEntity("/accessory",Accessory[].class);
        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertNotEquals(0,response.getBody().length);
    }

    @Test
    public void you_can_find_accessory_by_id()
    {
        ResponseEntity<Accessory> response = restTemplate.getForEntity("/accessory/7",Accessory.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Fries",response.getBody().getName());
    }

}
