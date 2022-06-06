import java.util.ArrayList;
import java.util.List;

public class TestCode {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
        System.out.println("");
        list.remove(2);
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }

}
