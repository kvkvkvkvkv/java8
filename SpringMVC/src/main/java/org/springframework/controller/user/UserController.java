package org.springframework.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.model.Course;
import org.springframework.model.User;
import org.springframework.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id){
//        can use either
//        return ResponseEntity.ok(userService.getUser(id));
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }

    @GetMapping("/user")
    public  ResponseEntity<List<User>> users(){
        return ResponseEntity.ok(userService.getUsers());
    }

    @PostMapping("/user")
    public ResponseEntity<User> addUser(@RequestBody User user){

        User newUser = userService.createUser(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newUser.getUserId())
                .toUri();

        return ResponseEntity.created(location).body(newUser);
    }

    @PutMapping("/user")
    public  ResponseEntity<User> updateUser(@RequestBody User user){
        User newUser = userService.updateUser(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newUser.getUserId())
                .toUri();

        return ResponseEntity.created(location).body(newUser);
    }

    @PatchMapping("/user/{id}")
    public  ResponseEntity<User> users(@RequestBody User user, @PathVariable Integer id){
        User newUser = userService.patchUser(user,id);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newUser.getUserId())
                .toUri();
        return ResponseEntity.created(location).body(newUser);
    }

    @DeleteMapping("/user/{id}")
    public  ResponseEntity<?> deleteUsers(@PathVariable Integer id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.GONE);
    }

    @GetMapping("/bi/{id}")
    public ResponseEntity<?> biCond(@PathVariable Integer id){
        userService.bicond(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/userProfile/{id}")
    public  ResponseEntity<?> deleteUserProfile(@PathVariable Integer id){
        userService.deleteUserProfile(id);
        return new ResponseEntity<>(HttpStatus.GONE);
    }

//    @PostMapping("/userCourse/{id}")
//    public ResponseEntity<Course> addUserCourse(@PathVariable Integer id, @RequestBody Course course){
//        Course addCourse = userService.addUserToCourse(id,course);
//        return new ResponseEntity<>(addCourse,HttpStatus.OK);
//    }

    @GetMapping("/userCourse/{id}")
    public ResponseEntity<Course> addUserCourse(@PathVariable Integer id){
        userService.addUserToCourse(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<List<Course>> getUserCourse(@PathVariable Integer id){
        List<Course> courses = userService.getUserCourse(id);
        return new ResponseEntity<List<Course>>(courses,HttpStatus.OK);
    }
}
