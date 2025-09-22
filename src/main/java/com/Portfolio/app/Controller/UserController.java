package com.Portfolio.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Portfolio.app.Dto.UserDto;
import com.Portfolio.app.Service.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public UserDto PostData(@Valid @RequestBody UserDto userDto){
        return userService.PostData(userDto);
    }

    @GetMapping()
    public List<UserDto> GetAllData() {
        return userService.GetAllData();
    }
    

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable Long id) throws Exception {
        return userService.GetById(id);
    }

    @DeleteMapping("/{id}")
    public String DeleteById(@PathVariable Long id) throws Exception{
        return userService.DeleteById(id);
    }

    @PutMapping("/{id}")
    public UserDto putDataById(@PathVariable Long id, @RequestBody UserDto userDto) throws Exception {
        
        
        return userService.UpdateDataById(userDto, id);
    }
    
}
