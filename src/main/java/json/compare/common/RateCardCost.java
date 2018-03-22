package json.compare.common;

import lombok.*;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class RateCardCost {

    private Long id;
    private Long fredCostId;
    private MeasurementType measurementType;
    private Integer ordinal;
    private Integer activeVersion;
    private String comment;
    private boolean bracketUsed;
    private boolean higherThatBracketUsed;
    private List<CostElement> elements;
}
