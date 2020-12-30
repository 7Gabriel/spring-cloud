package br.com.gabriel.hrpayroll.resources;

import br.com.gabriel.hrpayroll.entities.Payment;
import br.com.gabriel.hrpayroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

    @Autowired
    private PaymentService paymentService;

    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping(value = "/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable("workerId") Long workerId, @PathVariable("days") Integer days){
        Payment payment = paymentService.getPayment(workerId, days);
        return ResponseEntity.status(HttpStatus.OK).body(payment);
    }

    public ResponseEntity<Payment> getPaymentAlternative(Long workerId, Integer days){
        Payment payment = Payment.builder()
                .name("Brann")
                .dailyIncome(300.00)
                .days(days)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(payment);
    }


    
    
    
}
