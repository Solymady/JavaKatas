package katas.exercises;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class URLShortenerTest {

    private URLShortener shortener;

    @BeforeEach
    void setUp() {
        shortener = new URLShortener();
    }

    @Test
    void testRetrieveNonExistentShortUrl() {
        String nonExistentShortUrl = "http://short.ly/abcdef";
        assertNull(shortener.retrieve(nonExistentShortUrl));
    }


    @Test
    void testInvalidShortUrl() {
        String invalidShortUrl = "invalid_url";
        assertNull(shortener.retrieve(invalidShortUrl));
    }
}
