package by.myApp.testSpring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

    @GetMapping("/")
    public String helloSpring() {
        return "Spring is working!";
    }

    @GetMapping("/test")
    public String testNewTabSpring() {
        return "New tab with spring is working!";
    }

}