package day_035_collection.src.ch15;

import java.util.ArrayList;

public class ComparatorExample {
    public static void main(String[] args) {
        ArrayList<Fruit> fruits = new ArrayList<>();


        fruits.add(new Fruit("Apple", 100));
        fruits.add(new Fruit("Orange", 400));
        fruits.add(new Fruit("Pear", 200));
        fruits.add(new Fruit("Banana", 300));

//        fruits.sort(new Comparator<Fruit>() {
//            @Override
//            public int compare(Fruit o1, Fruit o2) {
//                return o1.price()-o2.price();
//            }
//        });

        fruits.sort((O1, O2)->O1.price()-O2.price());
        for (Fruit fruit : fruits) {
            System.out.println(fruit.name() + ":" + fruit.price());
        }
    }
}
