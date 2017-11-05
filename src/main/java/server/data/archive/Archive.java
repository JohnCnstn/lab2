package server.data.archive;

import lombok.Getter;
import lombok.Setter;

public class Archive {

    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    private String secondName;

    @Getter
    @Setter
    private String university;

    @Getter
    @Setter
    private byte avgScore;

    public Archive(long id, String firstName, String secondName, String university, byte avgScore) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.university = university;
        this.avgScore = avgScore;
    }
}
