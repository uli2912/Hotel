package kg.itschoolmegacom.hotelservice.models;

import kg.itschoolmegacom.hotelservice.models.Enum.RoomType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class Hotel {
    private int roomId;
    private double area;
    private int floor;
    private RoomType roomType;
    private double price;

    public Hotel(int roomId, double area, int floor, RoomType roomType, double price) {
        this.roomId = roomId;
        this.area = area;
        this.floor = floor;
        this.roomType = roomType;
        this.price = price;
    }
}
