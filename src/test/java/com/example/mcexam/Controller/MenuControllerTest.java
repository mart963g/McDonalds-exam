package com.example.mcexam.Controller;

import com.example.mcexam.model.Menu;
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
public class MenuControllerTest
{
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void application_returns_array_of_menus()
    {
        ResponseEntity<Menu[]> response = restTemplate.getForEntity("/menu",Menu[].class);
        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertNotEquals(0,response.getBody().length);
    }

    @Test
    public void you_can_find_menu_by_id()
    {
        ResponseEntity<Menu> response = restTemplate.getForEntity("/menu/13",Menu.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("BigMac Menu",response.getBody().getName());
    }

}
