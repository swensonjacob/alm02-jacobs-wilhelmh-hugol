package com.example.alm02jacobswilhelmhhugol;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class TranslatorTest {
    Translator translator = new Translator();

    @Test
    void getTheNumber() {
        assertEquals(29, translator.getTheNumber("Wilhelm","Germany",99));

    }

    @Test
    void getFortuneList() {
        assertTrue(translator.getFortuneList().size()>1);

    }

    @Test
    void getFortuneFromList() {
        assertEquals("All the effort you are making will ultimately pay off.", translator.getFortuneFromList("Wilhelm","germany",99));

    }
}