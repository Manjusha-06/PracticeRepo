package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.entity.User;
import com.klef.soa.service.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserServiceImpl impl;
	
   @GetMapping("/")
   public void home()
   {
	   System.out.println("Welcome to Home page");
   }
   
   @PostMapping("/addUser")
   public User addUser(@RequestBody User u)
   {
	   return impl.addUser(u);
   }
   
   @GetMapping("/displayall")
   public List<User> displayall()
   {
	   return impl.displayall();
   }
   
   @GetMapping("/displayById/{uid}")
   public ResponseEntity<User> displayById(@PathVariable Long uid) {

       User user = impl.displayById(uid);

       if (user != null) {
           return ResponseEntity.ok(user);
       }

       return ResponseEntity.notFound().build();
   }
   
   @PutMapping("/update")
   public User updateUser(@RequestBody User u)
   {
	   return impl.updateuser(u);
   }
   
   @DeleteMapping("/deleteuser/{id}")
   public String deleteuser(@PathVariable Long id)
   {
	   return impl.deleteUser(id);
   }
}
