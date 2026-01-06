package menu.service;


import menu.domain.Result;

import java.util.List;
import java.util.Map;

public class ResultDto {
    private final List<String> names;
    private final List<String> category;
    private final List<List<String>> results;

    public ResultDto(List<String> names,List<String> category, List<List<String>> results) {
        this.names=names;
        this.category = category;
        this.results = results;
    }

    public List<String> getNames() {
        return names;
    }

    public List<String> getCategory() {
        return category;
    }

    public List<List<String>> getResults() {
        return results;
    }
}
