package com.sd.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sd.example.model.Greeting;

public class GreetingUnitTest {
    @Test 
    public void testGetMessage() {
    	Greeting g = new Greeting(1, "Sibendu");
        assertEquals("Sibendu", g.getContent());
    }
}
