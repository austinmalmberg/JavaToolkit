import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Combinations {
	
	public Combinations() {}
	
	public <T> List<List<T>> get(List<T> list) {
		return generate(list).collect(Collectors.toList());
	}
	
	public <T> List<List<T>> get(List<T> list, int elements) {
		return generate(list)
				.filter(l -> l.size() == elements)
				.collect(Collectors.toList());
	}
	
	private <T> Stream<List<T>> generate(List<T> list) {
		return generate(list, Collections.emptyList());
	}
	
	private <T> Stream<List<T>> generate(List<T> list, List<T> sub) {
		return IntStream.range(0, list.size()).boxed()
				.flatMap(i -> {
					List<T> newSub = addToCombo(sub, list.get(i));
					return Stream.concat(Stream.of(newSub),	generate(list.subList(i+1, list.size()), newSub).parallel());
				});
	}
	
	private <T> List<T> addToCombo(List<T> combo, T t) {
		return Stream.concat(combo.stream(), Stream.of(t)).collect(Collectors.toList());
	}
}
