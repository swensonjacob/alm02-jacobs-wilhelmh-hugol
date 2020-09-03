package com.example.alm02jacobswilhelmhhugol;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class TranslatorTest {
    Translator translator = new Translator();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    void getTheNumber() {
        assertEquals(29, translator.getTheNumber("Wilhelm","Germany",99));
        assertEquals(2511, translator.getTheNumber("Wilhelmvonhattenbachus","Phillipines",10000));
    }

    @Test
    void getFortuneList() {
        assertTrue(translator.getFortuneList(translator.fileName).size()>1);

    }

    @Test
    void fileNotFoundException() {
        thrown.expect(FileNotFoundException.class);
        translator.getFortuneList("wrongfile.txt");
    }

    @Test
    void getFortuneFromList() {
        assertEquals("All the effort you are making will ultimately pay off.", translator.getFortuneFromList("Wilhelm","germany",99));

    }


}