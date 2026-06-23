package software.ulpgc.kata3.architecture.viewmodel;

import software.ulpgc.kata3.architecture.model.Movie;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

public class HistogramBuilder {

    private final Stream<Movie> movies;
    private final Map<String, String> labels;

    public static HistogramBuilder with(Stream<Movie> movies) {
        if (movies == null) throw  new IllegalArgumentException("movies cannot be null");
        return new HistogramBuilder(movies);
    }

    public HistogramBuilder(Stream<Movie> movies) {
        this.movies = movies;
        this.labels = new HashMap<>();
    }

    public HistogramBuilder title(String label) {
        this.labels.put("Title", label);
        return this;
    }

    public HistogramBuilder xAxis(String label) {
        this.labels.put("X", label);
        return this;
    }

    public HistogramBuilder yAxis(String label) {
        this.labels.put("Y", label);
        return this;
    }

    public HistogramBuilder legend(String label) {
        this.labels.put("Legend", label);
        return this;
    }

    public Histogram use(Function<Movie, Integer> function) {
        Histogram histogram = new Histogram(labels);
        movies.map(function).forEach(histogram::add);
        return histogram;
    }
}
