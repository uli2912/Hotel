package kg.itschoolmegacom.hotelservice.Controllers;


import kg.itschoolmegacom.hotelservice.service.FibonacciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/Fibonacci")
public class FibonacciController {


    private final FibonacciService fibonacciService;

    @Autowired
    public FibonacciController(FibonacciService fibonacciService) {
        this.fibonacciService = fibonacciService;
    }


    @GetMapping("/calculate/recursion/{number}")
    public Long calculateFiboNumber(@PathVariable Long number) {
    return fibonacciService.calculateFiboNumberRecursively(number);
    }

    @GetMapping("/calculate/array/{number}")
    public Long calculateFiboNumberArray(@PathVariable Long number) {
        return fibonacciService.calculateFiboNumberArray(number);
    }
}
