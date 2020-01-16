package jp.petrolingus.osudatabasereader;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;
import java.nio.file.Paths;

public class OsuDatabaseReader {

    public static void read(String path) {

        ByteBuffer byteBuffer;

        try {
            byte[] buffer = Files.readAllBytes(Paths.get(path));
            byteBuffer = ByteBuffer.wrap(buffer);
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
