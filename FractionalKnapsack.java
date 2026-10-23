import java.util.*;

class Item {
    double value, weight, ratio;
    Item(double v, double w) {
        value = v; weight = w; ratio = v / w;
    }
}

public class FractionalKnapsack {
    static double getMaxValue(Item[] items, double capacity) {
        // Sort items by value-to-weight ratio in descending order (Greedy step)
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        double totalValue = 0.0;
        for (Item item : items) {
            if (capacity >= item.weight) {
                // Take full item
                capacity -= item.weight;
                totalValue += item.value;
            } else {
                // Take fraction of item
                totalValue += item.ratio * capacity;
                break; // Knapsack is now full
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        Item[] items = { new Item(60, 10), new Item(100, 20), new Item(120, 30) };
        double capacity = 50;

        System.out.println("Max Value: " + getMaxValue(items, capacity));
    }
}