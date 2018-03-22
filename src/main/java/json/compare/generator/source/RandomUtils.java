package json.compare.generator.source;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public abstract class RandomUtils {

    public static boolean getRandomBoolean() {
        return new Random().nextBoolean();
    }

    public static Long getRandomLong() {
        return new Random().nextLong();
    }

    public static String getRandomMeasureName() {
        Lorem lorem = LoremIpsum.getInstance();

        return lorem.getWords(2);
    }

    public static String getRandomLoad() {
        return getRandomFromList(List.of("FTL/FCL", "LTL/LCL"));
    }

    public static String getRandomPort() {
        Lorem lorem = LoremIpsum.getInstance();

        return lorem.getWords(1);
    }

    public static String getRandomCityName() {
        Lorem lorem = LoremIpsum.getInstance();

        return lorem.getCity();
    }

    public static String getRandomCountryName() {
        Lorem lorem = LoremIpsum.getInstance();

        return lorem.getCountry();
    }

    public static String getRandomPostalCode() {
        Lorem lorem = LoremIpsum.getInstance();

        return lorem.getZipCode();
    }

    public static String getRandomTransportMode() {
        return getRandomFromList(List.of("Road", "Air", "Sea", "Rail", "Courier"));
    }

    public static String getRandomYorN() {
        return getRandomFromList(List.of("Y", "N"));
    }

    public static String getRandomCategory() {
        return getRandomFromList(List.of("Inbound", "Outbound"));
    }

    public static String getRandomIncoterm() {
        return getRandomFromList(
                List.of("CIF", "CFR", "FOB", "FAS", "EXW", "FCA", "DAT", "CPT", "CIP", "DAP", "DDP")
        );
    }

    public static String getRandomService() {
        return getRandomFromList(
                List.of("RoundTrip", "Standard", "MilkRun", "Distribution")
        );
    }

    public static String getRandomEquipItem() {
        return getRandomFromList(
                List.of("FTL/24T", "FTL/12T", "FTL/8T", "FCL/20F")
        );
    }

    public static String getRandomCarrier() {
        return getRandomFromList(
                List.of(
                        "DHL", "Panalpina", "DSV", "Expeditors", "Transsped", "UPS",
                        "Gefco", "Raben Logistics", "Lehman", "DHL Global"
                )
        );
    }

    private static String getRandomFromList(List<String> list) {
        return list.get(ThreadLocalRandom.current().nextInt(0, list.size()));
    }
}
