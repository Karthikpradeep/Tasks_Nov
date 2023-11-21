import java.util.Arrays;
import java.util.List;
public class StreamDuplicateOdd {
    public static void main(String[] args)
    {
        List<Integer> numbers = Arrays.asList(2,4,1,2,5,1,7,6);
        numbers.stream()
                        .distinct()
                        .filter(n -> n%2 == 1)
                        .forEach(n->System.out.println(n));
    }
}
