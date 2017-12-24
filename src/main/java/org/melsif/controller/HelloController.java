package org.melsif.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "hello";
    }

    @GetMapping(value = "/api/hello", produces = "application/json")
    public RestMessage helloUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return new RestMessage(String.format("Hello '%s'!", username));
    }

    @GetMapping(value = "/api/admin", produces = "application/json")
    public RestMessage helloAdmin() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return new RestMessage(String.format("Hello '%s'!", username));
    }

    public static class RestMessage {
        private String message;

        public RestMessage(String message) {
            this.message = message;
        }

        public String getMsg() {
            return message;
        }

        public void setMsg(String message) {
            this.message = message;
        }
    }
}
