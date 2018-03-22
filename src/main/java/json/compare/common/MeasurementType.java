package json.compare.common;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class MeasurementType {

    private Long id;
    private Long extId;
    private String name;
    private MeasurementGroupType measurementGroupType;
    private boolean deleted;
}
