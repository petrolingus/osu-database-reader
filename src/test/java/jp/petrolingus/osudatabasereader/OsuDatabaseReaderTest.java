package jp.petrolingus.osudatabasereader;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class OsuDatabaseReaderTest {

    @Test
    public void read_givenOsuDBPath_thenShouldReturnValidOsuDatabase() {

        OsuDatabase expected = new OsuDatabase();
        expected.setOsuVersion(20200111);
        expected.setFolderCount(1744);

        OsuDatabase actual = OsuDatabaseReader.read("D:\\MyOsuList\\osu!.db");

        System.out.println(actual);
        logToFile(actual);

        assertEquals(expected, actual);

    }

    public void logToFile(OsuDatabase obj) {
        String content = Arrays
                .stream(OsuDatabase.class.getDeclaredFields())
                .map(field -> {
                    try {
                        field.setAccessible(true);
                       String name = field.getName();
                       String value = Objects.toString(field.get(obj));
                       return name + ": " + value;
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.joining(System.lineSeparator()));
        try {
            Files.write(Paths.get("logs/log.txt"), content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
