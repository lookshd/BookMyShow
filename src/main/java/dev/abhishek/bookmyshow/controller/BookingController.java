package dev.abhishek.bookmyshow.controller;

import dev.abhishek.bookmyshow.service.BookingService;
import dev.abhishek.bookmyshow.service.BookingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/hello/{username}")
    public String hello(@PathVariable("username") String username) {
        return bookingService.hello(username);
    }
}
