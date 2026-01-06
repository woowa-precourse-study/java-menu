package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Results {
    private final List<Result> results=new ArrayList<>();

    public void add(Result result){
        results.add(result);
    }

    public List<Result> getResults() {
        return results;
    }

    public boolean isAvailable(String category){
        Map<String, Long> nameCounts = results.stream()
                .map(Result::getCategory)
                .collect(Collectors.groupingBy(
                        name -> name,
                        Collectors.counting()
                ));
        return (nameCounts.getOrDefault(category, 0L)<2);
    }
}
