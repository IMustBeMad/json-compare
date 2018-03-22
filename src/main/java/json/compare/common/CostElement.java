package json.compare.common;

import json.compare.dict.BracketOperator;
import json.compare.dict.CostElementType;
import json.compare.dict.RateApplicationRule;

import java.math.BigDecimal;

public class CostElement {

    private CostElementType elementType;
    private RateApplicationRule rateApplicationRule;
    private BracketOperator bracketOperator;
    private BigDecimal bracketRange;
}
