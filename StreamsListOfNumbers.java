
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
public class StreamsListOfNumbers {
    public static void main(String[] args){
        List<Integer> numbers = Arrays.asList(4,1,17,8,11,2);

        Stream<Integer> nums = numbers.stream();
        Stream<Integer> filteredStream = nums.filter(n -> n%2 == 0);
        //filteredStream.forEach(n -> System.out.println(n));
        Stream<Integer> sortedNumbers = filteredStream.sorted();
        Stream<Integer> doubledNumbers = sortedNumbers.map(n -> n*2);
        doubledNumbers.forEach(n -> System.out.println(n));

        numbers.stream()
                        .filter(n -> n%2 == 0)
                        .sorted()
                        .map(n ->n*2)
                        .forEach(System.out::println);


        
    }
}
