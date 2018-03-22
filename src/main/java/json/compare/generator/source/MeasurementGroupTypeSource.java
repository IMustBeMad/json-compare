package json.compare.generator.source;

import json.compare.common.MeasurementGroupType;
import org.springframework.stereotype.Component;

import static json.compare.generator.source.RandomUtils.getRandomBoolean;
import static json.compare.generator.source.RandomUtils.getRandomLong;
import static json.compare.generator.source.RandomUtils.getRandomMeasureName;

@Component
public class MeasurementGroupTypeSource implements Source<MeasurementGroupType> {

    @Override
    public MeasurementGroupType get() {
        MeasurementGroupType measurementGroupType = new MeasurementGroupType();

        measurementGroupType.setDeleted(getRandomBoolean());
        measurementGroupType.setExtId(getRandomLong());
        measurementGroupType.setId(getRandomLong());
        measurementGroupType.setName(getRandomMeasureName());

        return measurementGroupType;
    }
}
