package za.co.lzinc.heriplay.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/home")
public class HomeController {
    @RequestMapping
    public String home() {
        return "Welcome to HeriPlay API!";
    }
}
