import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

// 2353. Design a Food Rating System

class FoodRatings {
    Map<String,Integer> foodRating; // food , rating
    Map<String,String> foodCuisine; // food , cuisine
    Map<String, TreeSet<String>> cuisineFoods; // rating , name
    Map<String, Integer> ratingLookup;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodRating = new HashMap<>();
        foodCuisine = new HashMap<>();
        cuisineFoods = new HashMap<>();
        ratingLookup = new HashMap<>();

        for(int i=0 ; i < foods.length ; i++){
            String f = foods[i];
            String c = cuisines[i];
            int r = ratings[i];
            foodRating.put(f,r);
            foodCuisine.put(f,c);
            ratingLookup.put(f,r);
            cuisineFoods.putIfAbsent(c, new TreeSet<>((a, b) -> {
                int ra = ratingLookup.get(a);
                int rb = ratingLookup.get(b);
                if (ra != rb) return rb - ra;
                return a.compareTo(b);
            }));

            cuisineFoods.get(c).add(f);
        }
    }

    public void changeRating(String food, int newRating) {
        String c = foodCuisine.get(food);
        TreeSet<String> set = cuisineFoods.get(c);

        set.remove(food);
        foodRating.put(food, newRating);
        ratingLookup.put(food, newRating);
        set.add(food);
    }

    public String highestRated(String cuisine) {
        return cuisineFoods.get(cuisine).first();
    }
}

public class designAFoodRatingSystem {
    public static void main(String[] args) {
        String[] foods = {"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"};
        String[] cuisine = {"korean", "japanese", "japanese", "greek", "japanese", "korean"};
        int[] ratings = {9, 12, 8, 15, 14, 7};
        FoodRatings fr = new FoodRatings(foods,cuisine,ratings);
        System.out.println(fr.highestRated("korean"));
        System.out.println(fr.highestRated("japanese"));
        fr.changeRating("sushi", 16);
        System.out.println(fr.highestRated("japanese"));
        fr.changeRating("ramen", 16);
        System.out.println(fr.highestRated("japanese"));
    }
}