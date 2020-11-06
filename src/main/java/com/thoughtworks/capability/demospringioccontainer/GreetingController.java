package com.thoughtworks.capability.demospringioccontainer;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private final GreetingService greetingService;

    private final ObjectFactory<GreetingService> greetingServiceObjectFactory;

    @Autowired
    public GreetingController(GreetingService greetingService, ObjectFactory<GreetingService> greetingServiceObjectFactory) {
        this.greetingService = greetingService;
        this.greetingServiceObjectFactory = greetingServiceObjectFactory;
    }

    @GetMapping("/greet")
    public String greet() {
        return greetingServiceObjectFactory.getObject().sayHi();
    }

}
