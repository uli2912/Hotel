package kg.itschoolmegacom.hotelservice.service.impl;

import kg.itschoolmegacom.hotelservice.models.CalculateRequest;
import kg.itschoolmegacom.hotelservice.models.CalculateResponse;
import kg.itschoolmegacom.hotelservice.models.Enum.RoomType;
import kg.itschoolmegacom.hotelservice.models.Hotel;

import org.springframework.stereotype.Service;
import kg.itschoolmegacom.hotelservice.service.HotelService;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    private List<Hotel> hotelList = new ArrayList<>();
    {
        hotelList.add(new Hotel(1,45, 1, RoomType.STANDARD, 150));
        hotelList.add(new Hotel(2,60, 2, RoomType.COMFORT, 270));
        hotelList.add(new Hotel(3,75, 3, RoomType.LUX, 550));
        hotelList.add(new Hotel(4,90, 4, RoomType.PRESIDENT, 1300));

    }
    @Override
    public List<Hotel> getAllHotels() {

        return hotelList;
    }
    @Override
    public CalculateResponse calculate(CalculateRequest calculateRequest){
        Hotel hotel = findHotelByRoomId(calculateRequest.getRoomId());
        double discount = getDiscount(calculateRequest.getDays());

        double amount = calculateAmount(hotel, calculateRequest.getDays(), discount);
        return new CalculateResponse(amount, hotel, calculateRequest.getDays());
    }

    private double calculateAmount(Hotel hotel, int days, double discount) {
        return hotel.getPrice() * days - (hotel.getPrice() * days *discount)/100;
    }

    private double getDiscount(int days) {
         double discount = 0;

         if (days > 3 && days < 10) {
             discount = 5;
         } else if (days < 20 && days >= 10) {
             discount =  15;
         } else if (days >= 20) {
             discount = 30;
         }
        return discount;
    }

    private Hotel findHotelByRoomId(int roomId) {
        for (Hotel h : hotelList) {
            if (h.getRoomId() == roomId) {
                return h;
            }
        }
        throw new RuntimeException("This hotel wasn't founded" + roomId);
    }
}
