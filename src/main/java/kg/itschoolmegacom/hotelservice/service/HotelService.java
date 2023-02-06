package kg.itschoolmegacom.hotelservice.service;

import kg.itschoolmegacom.hotelservice.models.CalculateRequest;
import kg.itschoolmegacom.hotelservice.models.CalculateResponse;
import kg.itschoolmegacom.hotelservice.models.Hotel;

import java.util.List;

public interface HotelService {

    List<Hotel> getAllHotels();


    CalculateResponse calculate(CalculateRequest calculateRequest);
}
