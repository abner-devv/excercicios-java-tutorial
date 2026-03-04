import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Liam");
        names.add("Jenny");
        names.add("Kasper");
        names.add("Angie");

        Collections.sort(names); // must be sorted first
        int index = Collections.binarySearch(names, "Angie");
        System.out.println("Angie is at index: " + index);
    }
}
