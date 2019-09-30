package BankATM;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    int balance = 2000;
    String a = "1000";
    String ures = "";
    String minusz = "-200";
    String nagy = "3000";


    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void deposit() {

        File file = new File("/balance.json");
        assertTrue(file.exists());

    }

    @Test
    void equal() {
        if (a.isEmpty() || Integer.parseInt(a) < 0 || (balance - Integer.parseInt(a) < 0)) {
            assertEquals(1000, balance);
        }
    }

    @Test
    void nagy() {
        assertTrue(nagy.isEmpty() || Integer.parseInt(nagy) < 0 || (balance - Integer.parseInt(nagy) < 0));
    }

    @Test
    void notgood() {
        assertTrue(ures.isEmpty() || Integer.parseInt(ures) < 0 || (balance - Integer.parseInt(ures) < 0));
    }

    @Test
    void minusz() {
        assertTrue(minusz.isEmpty() || Integer.parseInt(minusz) < 0 || (balance - Integer.parseInt(minusz) < 0));
    }

    @Test
    void empty() {
        assertTrue(ures.isEmpty() || Integer.parseInt(a) < 0);
    }

    @Test
    void negative() {
        assertTrue(a.isEmpty() || Integer.parseInt(minusz) < 0);
    }

}