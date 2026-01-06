package menu.domain;

import java.util.Map;

public record Result(String category, Map<Crew,String> recommendedFood) {
}
