package software.ulpgc.kata3.viewmodel;

import software.ulpgc.kata3.model.Movie;

import java.util.List;
import java.util.function.Function;

public class HistogramBuilder {

    private final Function<Movie, Integer> decade;

    public HistogramBuilder(Function<Movie, Integer> decade) {
        this.decade = decade;
    }

    public Histogram build(List<Movie> movies) {
        Histogram histogram = new Histogram();
        for  (Movie movie : movies) histogram.add(decade.apply(movie));
        return histogram;
    }
}
