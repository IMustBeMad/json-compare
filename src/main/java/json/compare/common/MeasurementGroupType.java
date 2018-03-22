package json.compare.common;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class MeasurementGroupType {

    private Long id;
    private Long extId;
    private String name;
    private boolean deleted;
}
