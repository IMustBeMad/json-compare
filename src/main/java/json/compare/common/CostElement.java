package json.compare.common;

import json.compare.dict.BracketOperator;
import json.compare.dict.CostElementType;
import json.compare.dict.RateApplicationRule;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class CostElement {

    private CostElementType elementType;
    private RateApplicationRule rateApplicationRule;
    private BracketOperator bracketOperator;
    private BigDecimal bracketRange;
}
