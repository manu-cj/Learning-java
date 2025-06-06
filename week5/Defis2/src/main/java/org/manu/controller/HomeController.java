package org.manu.controller;

import org.manu.Dto.UserRequest;
import org.manu.Dto.UserResponse;
import org.manu.services.UserServices;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {
  private final UserServices userServices;

  public HomeController(UserServices userServices) {
    this.userServices = userServices;
  }

  @GetMapping("/hello")
  public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
    return String.format("Hello %s!", name);
  }




  @PostMapping("/user")
  @ResponseStatus(HttpStatus.CREATED)
  public UserResponse createUser(@Validated @RequestBody UserRequest userRequest) {
    return userServices.createUser(userRequest);
  }

  @GetMapping("/user")
  @ResponseStatus(HttpStatus.OK)
  public List<UserResponse> getAllUsers() {
    return userServices.getAllUser();
  }



  @GetMapping("/username")
  @ResponseStatus(HttpStatus.OK)
  public UserResponse getUserByUsername(@RequestParam(name = "username") String username) {
    return userServices.getByUsername(username);
  }



}