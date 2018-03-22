package json.compare.generator.source;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import json.compare.common.RateCardLane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

@Component
public class RateCardLaneSource implements Source<RateCardLane> {

    @Autowired
    private RateCardFieldSource rateCardFieldSource;

    @Autowired
    private JsonCostSource jsonCostSource;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public RateCardLane get() {
        Map<String, String> map = new HashMap<>();
        int costQuantity = ThreadLocalRandom.current().nextInt(0, 20);

        IntStream.range(0, costQuantity)
                 .forEach(it -> {
                     try {
                         map.put(RandomUtils.getRandomInt().toString(), objectMapper.writeValueAsString(jsonCostSource.get()));
                     } catch (JsonProcessingException e) {
                         e.printStackTrace();
                     }
                 });


        RateCardLane rateCardLane = new RateCardLane();
        rateCardLane.setFields(rateCardFieldSource.get());
        rateCardLane.setCosts(map);

        return rateCardLane;
    }
}
