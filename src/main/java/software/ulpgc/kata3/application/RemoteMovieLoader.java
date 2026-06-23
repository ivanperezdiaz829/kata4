package software.ulpgc.kata3.application;

import software.ulpgc.kata3.io.MovieLoader;
import software.ulpgc.kata3.model.Movie;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

public class RemoteMovieLoader implements MovieLoader {

    private static final String RemoteURL = "https://datasets.imdbws.com/title.basics.tsv.gz";
    private static final int bufferSize = 65545;

    @Override
    public List<Movie> loadMovies() throws IOException {
        return loadMoviesFrom(new URL(RemoteURL));
    }

    private List<Movie> loadMoviesFrom(URL url) throws IOException {
        return loadMoviesFrom(url.openConnection());
    }

    private List<Movie> loadMoviesFrom(URLConnection connection) throws IOException {
        try (InputStream is = new GZIPInputStream(new BufferedInputStream(connection.getInputStream(), bufferSize))) {
            return loadMoviesFrom(is);
        }
    }

    private List<Movie> loadMoviesFrom(InputStream is) throws IOException {
        return loadMoviesFrom(new BufferedReader(new InputStreamReader(is)));
    }

    private List<Movie> loadMoviesFrom(BufferedReader reader) throws IOException {
        List<Movie> movies = new ArrayList<>();
        TsvMovieParser parser = new TsvMovieParser();
        reader.readLine();
        while (true) {
            String line = reader.readLine();
            if (line == null) break;
            // System.out.println(line);
            movies.add(parser.from(line));
        }
        return movies;
    }
}
