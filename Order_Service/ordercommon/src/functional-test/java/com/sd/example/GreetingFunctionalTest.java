/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.sd.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sd.example.model.Greeting;

public class GreetingFunctionalTest {
    @Test 
    public void testGetMessage() {
    	Greeting g = new Greeting(1, "Sibendu");
        assertEquals("Sibendu", g.getContent());
    }
}
