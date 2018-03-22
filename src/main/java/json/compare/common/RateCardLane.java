package json.compare.common;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class RateCardLane {

    private RateCardField fields;
    private Map<String, String> costs;
}
