package vn.test.zkoss.models;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    private int id;
    private String model;
    private String make;
    private String description;
    private String preview;
    private long price;

}
