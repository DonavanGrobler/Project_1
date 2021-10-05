package za.ac.nwu.as.web.sb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.nwu.as.domain.service.GeneralResponse;

@RestController

public class DemoController {
    @GetMapping("/ping")
    public GeneralResponse<String> getAll(){return new GeneralResponse<String>(true, "No types found"); }
}