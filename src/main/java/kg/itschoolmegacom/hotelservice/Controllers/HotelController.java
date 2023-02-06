package kg.itschoolmegacom.hotelservice.Controllers;

import kg.itschoolmegacom.hotelservice.models.CalculateRequest;
import kg.itschoolmegacom.hotelservice.models.CalculateResponse;
import kg.itschoolmegacom.hotelservice.models.Hotel;
import kg.itschoolmegacom.hotelservice.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("api/v1/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;
    @GetMapping("/list")
    public List<Hotel> getHotels() {

        return hotelService.getAllHotels();
    }
    @PostMapping("/calculate")
    public CalculateResponse calculatePrice(@RequestBody CalculateRequest calculateRequest) {
        return hotelService.calculate(calculateRequest);
    }
}
