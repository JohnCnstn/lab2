package server.data.profile;

import lombok.Getter;
import lombok.Setter;

public class Profile {

    @Getter
    @Setter
    private int id;

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

    public Profile(int id, String firstName, String secondName, String university, byte avgScore) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.university = university;
        this.avgScore = avgScore;
    }

    public Profile() {
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", university='" + university + '\'' +
                ", avgScore=" + avgScore +
                '}';
    }
}
