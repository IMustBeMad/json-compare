package json.compare.generator.source;

import json.compare.common.JsonCost;
import org.springframework.stereotype.Component;

@Component
public class JsonCostSource implements Source<JsonCost> {

    @Override
    public JsonCost get() {
        JsonCost jsonCost = new JsonCost();

        jsonCost.setCurrency(RandomUtils.getRandomCurrency());
        jsonCost.setDefaultCost(RandomUtils.getRandomInt().toString());
        jsonCost.setMax(RandomUtils.getRandomInt().toString());
        jsonCost.setMin(RandomUtils.getRandomInt().toString());

        return jsonCost;
    }
}
