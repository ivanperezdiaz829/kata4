package software.ulpgc.kata3.application;

import software.ulpgc.kata3.architecture.model.Movie;
import software.ulpgc.kata3.architecture.viewmodel.Histogram;
import software.ulpgc.kata3.architecture.viewmodel.HistogramBuilder;

import java.io.IOException;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) throws IOException {
        Desktop.create().display(histogram()).setVisible(true);
    }

    private static Histogram histogram() throws IOException {
        return HistogramBuilder
                .with(movies())
                .title("Movies Per Decade")
                .xAxis("Decade")
                .yAxis("Count")
                .legend("Kata 4")
                .use(Movie::year);
    }

    private static Stream<Movie> movies() throws IOException {
        return new RemoteStore(TsvMovieParser::from).movies().limit(1000);
    }
}