package za.co.lzinc.heriplay.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @RequestMapping("/dashboard")
    public String admin(){
        return "admin";
    }
}
