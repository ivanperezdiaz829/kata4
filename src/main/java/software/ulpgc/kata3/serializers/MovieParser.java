package software.ulpgc.kata3.serializers;

import software.ulpgc.kata3.model.Movie;

public interface MovieParser {
    Movie from(String str);
}
