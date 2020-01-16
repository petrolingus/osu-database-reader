package jp.petrolingus.osudatabasereader;

import java.util.Objects;

public class OsuDatabase {

    private int osuVersion;

    public OsuDatabase() {

    }

    public OsuDatabase(int osuVersion) {
        this.osuVersion = osuVersion;
    }

    public int getOsuVersion() {
        return osuVersion;
    }

    public void setOsuVersion(int osuVersion) {
        this.osuVersion = osuVersion;
    }

    @Override
    public String toString() {
        return "OsuDatabase{" +
                "osuVersion=" + osuVersion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OsuDatabase database = (OsuDatabase) o;
        return osuVersion == database.osuVersion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(osuVersion);
    }
}
