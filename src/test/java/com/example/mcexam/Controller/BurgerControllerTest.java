package com.example.mcexam.Controller;

import com.example.mcexam.model.Burger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
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

    @Test
    public void you_can_find_burger_by_id()
    {
        ResponseEntity<Burger> response = restTemplate.getForEntity("/burger/1",Burger.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("BigMac",response.getBody().getName());
    }

    @Test
    public void you_can_save_burger()
    {
        Burger testBurger = new Burger("Hamburger",10.00);
        ResponseEntity<Burger> response = restTemplate.postForEntity(
                "/burger", testBurger, Burger.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(testBurger.getName(),response.getBody().getName());
    }

    @Test
    public void you_can_update_burger()
    {
        ResponseEntity<Burger> response = restTemplate.getForEntity("/burger/3",Burger.class);
        assertEquals(HttpStatus.OK,response.getStatusCode());
        Burger burger = response.getBody();
        burger.setName("New Burger");
        burger.setPrice(20.00);
        HttpEntity<Burger> burgerHttpEntity = new HttpEntity<>(burger);
        ResponseEntity<Burger> response2 = restTemplate.exchange(
                "/burger/3", HttpMethod.PUT, burgerHttpEntity, Burger.class);
        assertEquals(HttpStatus.OK, response2.getStatusCode());
        assertEquals(burger.getName(),response2.getBody().getName());

    }

    @Test
    public void you_can_delete_burger_by_id()
    {
        ResponseEntity<Burger> response = restTemplate.exchange(
            "/burger/2",HttpMethod.DELETE,null,Burger.class);
        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertNull(response.getBody());
        ResponseEntity<Burger> response2 = restTemplate.getForEntity("/burger/2",Burger.class);
        assertNotEquals(HttpStatus.OK,response2.getStatusCode());
    }
}
