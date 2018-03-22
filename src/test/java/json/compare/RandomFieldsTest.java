package json.compare;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import json.compare.common.RateCardField;
import json.compare.common.RateCardLane;
import json.compare.generator.source.RateCardLaneSource;
import org.assertj.core.api.Assertions;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RandomFieldsTest {

    private static final int QUANTITY = 15000;

//    @Autowired
//    private RateCardFieldSource rateCardFieldSource;

    @Autowired
    private RateCardLaneSource rateCardLaneSource;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testParsingWithJackson() throws IOException {
//        List<RateCardField> parsedFields = new ArrayList<>();
        List<RateCardLane> rateCardLanes = new ArrayList<>();
        List<String> jsonList = getJsonList();

//        String json = objectMapper.writeValueAsString(getLane());
//        rateCardLanes.add(objectMapper.readValue(json, RateCardLane.class));

        long start = System.currentTimeMillis();
        for (String json : jsonList) {
            RateCardLane rateCardLane = objectMapper.readValue(json, RateCardLane.class);
            String dangerousGoods = rateCardLane.getFields().getDangerousGoods();

            Assertions.assertThat(List.of("Y", "N")).contains(dangerousGoods);
            rateCardLanes.add(rateCardLane);
        }
        long timeElapsed = System.currentTimeMillis() - start;

        System.out.println("Parsing " + QUANTITY + " lanes json with Jackson took " + timeElapsed + " (ms)");
    }

    @Test
    public void testParsingWithJGson() throws IOException {
        List<RateCardField> parsedFields = new ArrayList<>();
        List<String> jsonList = getJsonList();
        Gson gson = new GsonBuilder().create();

        long start = System.currentTimeMillis();
        for (String json : jsonList) {
            parsedFields.add(gson.fromJson(json, RateCardField.class));
        }
        long timeElapsed = System.currentTimeMillis() - start;

        System.out.println("Parsing " + QUANTITY + " fields json with Gson took " + timeElapsed + " (ms)");
    }

    @Test
    public void testParsingWithJsonSimple() throws IOException, ParseException {
        List<JSONObject> parsedFields = new ArrayList<>();
        List<String> jsonList = getJsonList();
        JSONParser jsonParser = new JSONParser();

        long start = System.currentTimeMillis();
        for (String json : jsonList) {
            parsedFields.add((JSONObject) jsonParser.parse(json));
        }
        long timeElapsed = System.currentTimeMillis() - start;

        System.out.println("Parsing " + QUANTITY + " fields json with JSON.Simple took " + timeElapsed + " (ms)");
    }

    @Test
    public void testParsingWithJsonP() throws IOException {
        List<JsonObject> parsedFields = new ArrayList<>();
        List<String> jsonList = getJsonList();

        long start = System.currentTimeMillis();
        for (String json : jsonList) {
            JsonReader reader = Json.createReader(new StringReader(json));
            parsedFields.add(reader.readObject());
        }
        long timeElapsed = System.currentTimeMillis() - start;

        System.out.println("Parsing " + QUANTITY + " fields json with Jsonp took " + timeElapsed + " (ms)");
    }

//    private List<String> getJsonList() throws JsonProcessingException {
//        List<RateCardField> rateCardFields = rateCardFieldSource.generate(QUANTITY);
//        List<String> jsonList = new ArrayList<>();
//
//        for (RateCardField rateCardField : rateCardFields) {
//            jsonList.add(objectMapper.writeValueAsString(rateCardField));
//        }
//
//        return jsonList;
//    }

    private List<String> getJsonList() throws JsonProcessingException {
        List<RateCardLane> rateCardFields = rateCardLaneSource.generate(QUANTITY);
        List<String> jsonList = new ArrayList<>();

        for (RateCardLane rateCardLane : rateCardFields) {
            jsonList.add(objectMapper.writeValueAsString(rateCardLane));
        }

        return jsonList;
    }

    @Test
    public void quantityTest() {
        IntStream.range(0, 10)
                 .forEach(it -> {
                     try {
                         testParsingWithJackson();
                     } catch (IOException e) {
                         e.printStackTrace();
                     }
                 });
    }

//    private RateCardLane getLane() {
//        Map<String, String> costs = new HashMap<>();
//        costs.put("74", "{\"CURRENCY\":\"USD\", \"MIN\":\"89\", \"MAX\":\"90\"}");
//        costs.put("115", "{\"CURRENCY\":\"EUR\", \"MIN\":\"11\", \"MAX\":\"145\"}");
//
//        RateCardLane jsonWrapper = new RateCardLane();
//        jsonWrapper.setFields(rateCardFieldSource.get());
//        jsonWrapper.setCosts(costs);
//
//        return jsonWrapper;
//    }
}
