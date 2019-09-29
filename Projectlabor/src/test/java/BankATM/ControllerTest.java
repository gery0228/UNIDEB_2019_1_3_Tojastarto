package BankATM;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void deposit() {

        File file = new File("/Users/ktomi/Desktop/UNIDEB_2019_1_3_Tojastarto/Projectlabor/balance.json");
        assertTrue(file.exists());

    }

}