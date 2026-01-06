package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Results {
    private final List<String> categories=new ArrayList<>();
    private final List<Result> results=new ArrayList<>();

    public void addCategory(String category){
        categories.add(category);
    }

    public void add(Result result){
        results.add(result);
    }

    public void addFood(Result result,String food){
        result.add(food);
    }

    public boolean isAvailableCategory(String category){
        return Collections.frequency(categories, category)<2;
    }



    public Result findByName(String name){
        Optional<Result> result = results.stream()
                .filter(a -> a.getName().equals(name))
                .findFirst();
        Result result1=null;

        if (result.isEmpty()){
            result1=new Result(name);
            results.add(result1);
        }
        return result.orElse(result1);
    }

    public List<List<String>> getResults() {
        List<List<String>> foodList=new ArrayList<>();
        for (Result result:results){
            foodList.add(result.getRecommendedFood());
        }
        return foodList;
    }

    public List<String> getCategories() {
        return categories;
    }

    public boolean isAvailable(String category){
        return (Collections.frequency(categories, category)<2);
    }
}
