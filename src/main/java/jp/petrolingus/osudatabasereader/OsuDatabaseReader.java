package jp.petrolingus.osudatabasereader;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;
import java.nio.file.Paths;

public class OsuDatabaseReader {

    ByteBuffer byteBuffer;

    public void read(String path) {

        try {
            byte[] buffer = Files.readAllBytes(Paths.get(path));
            byteBuffer = ByteBuffer.wrap(buffer);
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
