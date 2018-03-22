package json.compare.common;

import lombok.*;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class RateCardLane {

    private RateCardField fields;
    private List<RateCardCost> costs;
}
