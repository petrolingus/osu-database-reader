package jp.petrolingus.osudatabasereader;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;
import java.nio.file.Paths;

public class OsuDatabaseReader {

    public static OsuDatabase read(String path) {

        ByteBuffer byteBuffer;

        try {
            byte[] buffer = Files.readAllBytes(Paths.get(path));
            byteBuffer = ByteBuffer.wrap(buffer);
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        } catch (IOException e) {
            throw new IllegalArgumentException("Could't read osu!.db: " + path, e);
        }

        OsuDatabase database = new OsuDatabase();
        database.setOsuVersion(getOsuVersion(byteBuffer));
        database.setFolderCount(getFolderCount(byteBuffer));

        return database;
    }

    private static int getOsuVersion(ByteBuffer byteBuffer) {
        return byteBuffer.getInt();
    }

    private static int getFolderCount(ByteBuffer byteBuffer) {
        return byteBuffer.getInt();
    }

    private static boolean getAccountUnlocked(ByteBuffer byteBuffer) {
        return byteBuffer.get() != 0;
    }

    private static long getDateTime(ByteBuffer byteBuffer) {
        return byteBuffer.getLong();
    }



}
