package kg.itschoolmegacom.hotelservice.service.impl;

import kg.itschoolmegacom.hotelservice.service.FibonacciService;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class FibonaccServiceImpl implements FibonacciService {

    @Override
    public Long calculateFiboNumberRecursively(@PathVariable Long number) {
        if (number==0 || number == 1){
            return number;
        }
    return calculateFiboNumberRecursively(number - 1) + calculateFiboNumberRecursively(number - 2);
    }

    @Override
    public Long calculateFiboNumberArray(Long number) {
        long[] fiboNumbers = new long[(int) (number + 1)];
        fiboNumbers[0] = 0;
        fiboNumbers[1] = 1;
        for (long i = 2; i <= number; i++) {
            fiboNumbers[(int) i] = fiboNumbers[(int) (i -1)] + fiboNumbers[(int) (i - 2)];
        }
        return fiboNumbers[Math.toIntExact(number)];
    }
}
