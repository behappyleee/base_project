import java.util.ArrayList;
import java.util.List;

public class SequenceCollections {


    public static void main(String[] args) {

        // Java 21 version new feature

        // To access last element of list
        // In Java 21 can finally replace this behemoth with a short and concise call;

        List<String> list = new ArrayList<String>();

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        // Old Version (To access last element list collection)
        String lastEle = list.get(list.size() - 1);

        // In Java 21 can easily access last element
        var lastElement = list.getLast();


    }

}
