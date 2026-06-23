package software.ulpgc.kata3.architecture.io;

import software.ulpgc.kata3.architecture.model.Movie;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.stream.Stream;

public interface Store {
    Stream<Movie> movies() throws IOException;
}
