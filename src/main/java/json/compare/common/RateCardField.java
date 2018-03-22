package json.compare.common;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class RateCardField {

    private String load;
    private String airline;
    private String shipPort;
    private String shipCity;
    private String laneId;
    private String custAirport;
    private String dangerousGoods;
    private String carrier;
    private String shipAirport;
    private String custSeaport;
    private String shipSeaport;
    private String category;
    private String custPort;
    private String adr;
    private String toPostalCode;
    private String equipItem;
    private String serviceProduct;
    private String fromPostalCode;
    private String fromCountry;
    private String toCountry;
    private String transportMode;
    private String incoterms;
}
