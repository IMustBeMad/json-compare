package json.compare.generator.source;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public interface Source<T> {

    default List<T> generate(int quantity) {
        return IntStream.range(0, quantity)
                        .boxed()
                        .map(it -> get())
                        .collect(toList());
    }

    T get();
}
