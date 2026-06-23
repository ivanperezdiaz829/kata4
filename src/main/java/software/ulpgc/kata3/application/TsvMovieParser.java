package software.ulpgc.kata3.application;

import software.ulpgc.kata3.model.Movie;
import software.ulpgc.kata3.serializers.MovieParser;

public class TsvMovieParser implements MovieParser {
    @Override
    public Movie from(String str) {
        return from(str.split("\t"));
    }

    private Movie from(String[] str) {
        return new Movie(str[2], toInt(str[5]), toInt(str[7]));
    }

    private int toInt(String str) {
        if (isVoid(str)) return -1;
        return Integer.parseInt(str);
    }

    private boolean isVoid(String str) {
        return str.equals("\\N");
    }
}
