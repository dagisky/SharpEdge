package com.sharpEdge.clients.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("USERSERVICE")
public interface UserClient {

    @GetMapping("api/v1/user/{username}")
    public CustomerResponse getCardOwner(@PathVariable("username") String username);
}
