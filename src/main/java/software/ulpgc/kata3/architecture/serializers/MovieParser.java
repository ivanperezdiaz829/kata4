package software.ulpgc.kata3.architecture.serializers;

import software.ulpgc.kata3.architecture.model.Movie;

public interface MovieParser {
    Movie from(String str);
}
