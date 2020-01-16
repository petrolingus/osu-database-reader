package jp.petrolingus.osudatabasereader;

import org.junit.Test;

import static org.junit.Assert.*;

public class OsuDatabaseReaderTest {

    @Test
    public void read_givenOsuDBPath_thenShouldReturnValidOsuDatabase() {

        OsuDatabase expected = new OsuDatabase();
        expected.setOsuVersion(20200111);

        OsuDatabase actual = OsuDatabaseReader.read("D:\\MyOsuList\\osu!.db");

        System.out.println(actual);

        assertEquals(expected, actual);

    }

}
