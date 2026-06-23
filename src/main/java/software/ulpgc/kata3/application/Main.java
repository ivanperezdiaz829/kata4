package software.ulpgc.kata3.application;

import software.ulpgc.kata3.model.Movie;
import software.ulpgc.kata3.viewmodel.Histogram;
import software.ulpgc.kata3.viewmodel.HistogramBuilder;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        RemoteMovieLoader remoteMovieLoader = new RemoteMovieLoader();
        List<Movie> movies = remoteMovieLoader.loadMovies();
        Histogram histogram = new HistogramBuilder(m->(m.year() / 10) * 10).build(movies);
        for (int d : histogram) {
            System.out.println(d + ": " + histogram.count(d));
        }
    }
}
