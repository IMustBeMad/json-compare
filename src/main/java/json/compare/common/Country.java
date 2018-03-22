package json.compare.common;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Country {

    private Long id;
    private String name;
    private String code;
}
