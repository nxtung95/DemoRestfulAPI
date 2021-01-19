package todolist.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import todolist.dto.UserDto;
import todolist.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;
	
    @GetMapping("/api/v1/users")
    public ResponseEntity<List<UserDto>> getUsers() {
        List<UserDto> response = userService.getUsers();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @GetMapping("/api/v1/users/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable(value = "userId") Integer userId) {
        UserDto response = userService.getUser(userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @PostMapping("api/v1/users")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
    	UserDto response = userService.saveUser(userDto);
    	return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @PutMapping("api/v1/users")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto) {
    	System.out.println(userDto.getId());
    	UserDto response = userService.saveUser(userDto);
    	return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @DeleteMapping("api/v1/users/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable(value = "userId") Integer userId) {
    	userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
