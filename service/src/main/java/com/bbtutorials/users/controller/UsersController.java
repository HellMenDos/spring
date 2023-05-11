package com.bbtutorials.users.controller;

import com.bbtutorials.users.entity.Users;
import com.bbtutorials.users.links.UserLinks;
import com.bbtutorials.users.service.UsersService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class UsersController {

  private final UsersService usersService;

  @GetMapping(path = UserLinks.LIST_USERS)
  public ResponseEntity<?> listUsers() {
    log.info("UsersController:  list users");
    List<Users> resource = usersService.getUsers();
    return ResponseEntity.ok(resource);
  }

  @PostMapping(path = UserLinks.ADD_USER)
  public ResponseEntity<?> saveUser(@RequestBody Users user) {
    log.info("UsersController:  list users");
    Users resource = usersService.saveUser(user);
    return ResponseEntity.ok(resource);
  }
}
