package Day_6;
import java.util.ArrayList;

public class TestGeneric {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("h1");
        list.add("h4");
        list.add("h3");
        list.add("h2");
        Generic<String> g = new Generic<>(list);
        g.display();

        // float 
        ArrayList<Float> list2 = new ArrayList<>();
        list2.add(10.1f);
        list2.add(10.1f);
        list2.add(10.1f);
        list2.add(10.1f);
        Generic<Float> f = new Generic<>(list2);
        f.display();

        // integer
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(10);
        list3.add(10);
        list3.add(10);
        Generic<Integer> i = new Generic<>(list3);
        i.display();
    }
}
