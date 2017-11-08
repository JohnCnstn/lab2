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
