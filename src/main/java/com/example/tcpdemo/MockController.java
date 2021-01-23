package com.example.tcpdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MockController {

    @Autowired
    ResponseMessage responseMessage;

    @PostMapping("/response")
    public void setResponseMessage(@RequestBody String response){

        System.out.println("RESPOSE IS : " + response);
        responseMessage.setResponseMessage(response);
    }
}
