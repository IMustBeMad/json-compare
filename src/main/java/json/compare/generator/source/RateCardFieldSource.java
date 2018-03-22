package json.compare.generator.source;

import json.compare.common.RateCardField;
import org.springframework.stereotype.Component;

import static json.compare.generator.source.RandomUtils.*;

@Component
public class RateCardFieldSource implements Source<RateCardField> {

    @Override
    public RateCardField get() {
        RateCardField rateCardField = new RateCardField();

        rateCardField.setLoad(getRandomLoad());
        rateCardField.setAirline(getRandomPort());
        rateCardField.setShipPort(getRandomPort());
        rateCardField.setShipCity(getRandomCityName());
        rateCardField.setLaneId(getRandomLong().toString());
        rateCardField.setCustAirport(getRandomPort());
        rateCardField.setDangerousGoods(getRandomYorN());
        rateCardField.setCarrier(getRandomCarrier());
        rateCardField.setShipAirport(getRandomPort());
        rateCardField.setCustSeaport(getRandomPort());
        rateCardField.setShipSeaport(getRandomPort());
        rateCardField.setCategory(getRandomCategory());
        rateCardField.setCustPort(getRandomPort());
        rateCardField.setAdr(getRandomYorN());
        rateCardField.setToPostalCode(getRandomPostalCode());
        rateCardField.setEquipItem(getRandomEquipItem());
        rateCardField.setServiceProduct(getRandomService());
        rateCardField.setFromPostalCode(getRandomPostalCode());
        rateCardField.setFromCountry(getRandomCountryName());
        rateCardField.setToCountry(getRandomCountryName());
        rateCardField.setTransportMode(getRandomTransportMode());
        rateCardField.setIncoterms(getRandomIncoterm());

        return rateCardField;
    }
}
