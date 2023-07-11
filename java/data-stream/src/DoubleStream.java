import java.util.Arrays;

public class DoubleStream {

    public static void main(String[] args) {
        double[] doubles = {2.9, 3.5, 4.7, 5.3, 6.7, 8.5, 10.2, 11.5, 11.7};
        
        // Double 타입에 Stream 을 생성
        java.util.stream.DoubleStream ds = Arrays.stream(doubles);
        ds.forEach(System.out::println);

    }
}
