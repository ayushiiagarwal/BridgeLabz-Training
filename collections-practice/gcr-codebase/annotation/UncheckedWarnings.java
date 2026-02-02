import java.util.*;

public class UncheckedWarnings {
    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        ArrayList list = new ArrayList();
        list.add("Hello");
        list.add(1);

        String ans = (String) list.get(0);
        System.out.println(ans);
    }
}
