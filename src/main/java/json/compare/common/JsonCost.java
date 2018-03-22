package json.compare.common;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class JsonCost {

    private String currency;
    private String min;
    private String defaultCost;
    private String max;
}
