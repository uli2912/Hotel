package kg.itschoolmegacom.hotelservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CalculateResponse {
    private double cost;
    private Hotel hotel;
    private int days;
}
