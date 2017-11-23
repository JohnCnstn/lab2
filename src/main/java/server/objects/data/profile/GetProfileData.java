package server.objects.data.profile;

import java.io.BufferedReader;
import java.io.PrintWriter;

public interface GetProfileData {
    void getProfileData(PrintWriter out, BufferedReader in);
}
