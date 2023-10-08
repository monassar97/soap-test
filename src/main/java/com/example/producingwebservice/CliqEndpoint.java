package com.example.producingwebservice;

import localhost._6050.ws.send.SendRequest;
import localhost._6050.ws.send.SendResponse;
import localhost._6050.ws.send.UserType;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.math.BigInteger;


@Endpoint
public class CliqEndpoint {
    private static final String NAMESPACE_URI = "http://localhost:6050/ws/send";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "sendRequest")
    @ResponsePayload
    public SendResponse send(@RequestPayload SendRequest data) {
        System.out.println("request.toString() = " + data);

        SendResponse res = new SendResponse();
        UserType userType = new UserType();
        userType.setAge(BigInteger.valueOf(25));
        userType.setName("Ahmad");
        res.setUser(userType);
        return res;
    }
}
