import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {	
		Combinations combos = new Combinations();
		
		int max = 20;
		List<Integer> range = IntStream.range(0, max).mapToObj(Integer::valueOf).collect(Collectors.toList());

		long start = System.currentTimeMillis();
		
		combos.get(range, 6).forEach(System.out::println);
		
		System.out.printf("Completed in %d seconds.%n", (System.currentTimeMillis() - start) / 1000);
	}	
}
