package de.krakowski.lukas.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class KlientenAbfrageServiceTest {
    
    private KlientenAbfrageService cut;

    @BeforeEach
    void setup() {
        cut = new KlientenAbfrageService();
    }

    @Test
    void testKlientenAbfrage() {

        var klient = cut.klientenAbfrage(null);
        assertNotNull(klient);
    }
}
