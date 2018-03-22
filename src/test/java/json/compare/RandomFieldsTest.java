package json.compare;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import json.compare.common.RateCardField;
import json.compare.generator.source.RateCardFieldSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RandomFieldsTest {

    private static final int QUANTITY = 15000;

    @Autowired
    private RateCardFieldSource rateCardFieldSource;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testParsingWithJackson() throws IOException {
        List<RateCardField> parsedFields = new ArrayList<>();
        List<String> jsonList = getJsonList();

        long start = System.currentTimeMillis();
        for (String json : jsonList) {
            parsedFields.add(objectMapper.readValue(json, RateCardField.class));
        }
        long timeElapsed = System.currentTimeMillis() - start;

        System.out.println("Parsing " + QUANTITY + " fields json with Jackson took " + timeElapsed + " (ms)");
    }

    private List<String> getJsonList() throws JsonProcessingException {
        List<RateCardField> rateCardFields = rateCardFieldSource.generate(QUANTITY);
        List<String> jsonList = new ArrayList<>();

        for (RateCardField rateCardField : rateCardFields) {
            jsonList.add(objectMapper.writeValueAsString(rateCardField));
        }

        return jsonList;
    }
}
