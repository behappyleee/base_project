import java.util.Arrays;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class GetStream {

    private final static Logger LOG = Logger.getGlobal();

    public static void main(String[] args) {

        // Get Stream from Collection
        double [] doubles = {2.3, 3.5, 4.7, 5.3, 6.4, 7.9, 1.3, 3.5};
        Stream st = Arrays.asList(doubles).stream();

        LOG.severe("THIS IS LOG TEST !");
        LOG.info("THIS IS LOG INFO TEST !!!");


    }


}
