package com.example.controller;

import com.example.service.OrgoneService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

@Controller("/orgoneCalculator")
public class TestController {

    private final Logger logger = LoggerFactory.getLogger(TestController.class);
    private final Random random = new Random();
    private final OrgoneService orgoneService;

    public TestController(OrgoneService orgoneService) {
        this.orgoneService = orgoneService;
    }

    @Get(value = "/user/{userId}")
    String getUserById(String userId) {
        int totalOrgones = orgoneService.calculateTotalOrgonesForUser(userId);

        return String.format(
                "Hello user %s 👋, I've calculated your total Orgone count to be %d",
                userId,
                totalOrgones
        );
    }
}
