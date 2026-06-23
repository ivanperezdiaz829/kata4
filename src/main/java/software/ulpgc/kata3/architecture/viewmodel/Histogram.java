package software.ulpgc.kata3.architecture.viewmodel;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Histogram implements Iterable<Integer> {

    private final Map<Integer, Integer> map;
    private final Map<String, String> labels;

    public Histogram(Map<String, String> labels) {
        this.labels = labels;
        this.map = new HashMap<>();
    }

    public void add(int d) {
        map.put(d, count(d) + 1);
    }

    public Integer count(int d) {
        return map.getOrDefault(d, 0);
    }

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public String title() {
        return labels.getOrDefault("title", "");
    }

    public String xAxis() {
        return labels.getOrDefault("X", "");
    }

    public String yAxis() {
        return labels.getOrDefault("Y", "");
    }

    public String legend() {
        return labels.getOrDefault("Legend", "");
    }

    @Override
    public Iterator<Integer> iterator() {
        return map.keySet().iterator();
    }
}
