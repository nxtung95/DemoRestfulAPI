package course.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import course.dto.UserRequestDto;
import course.dto.UserResponseDto;
import course.error.ErrorCode;
import course.error.ErrorMessage;
import course.exception.ExistEmailException;
import course.service.EmailService;
import course.service.UserService;
import course.service.UserServiceFactory;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {
	private final UserServiceFactory userServiceFactory;
	private final EmailService emailService;
	
    @PostMapping("api/v1/users")
    @ApiOperation("Create user")
    @ApiResponses({
		@ApiResponse(code = 200, message = "Create user successfully"),
		@ApiResponse(code = 400, message = "Invalid request")
	})
    public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody UserRequestDto userRequestDto) throws Exception {
		boolean isExistEmail = emailService.checkExistEmail(userRequestDto.getEmail());
		if(isExistEmail) {
			throw new ExistEmailException(HttpStatus.BAD_REQUEST, ErrorCode.USER_E004, ErrorMessage.USER_E004);
		}
    	UserService service = userServiceFactory.createUser(userRequestDto.getMode());
    	UserResponseDto userResponse = service.saveUser(userRequestDto);
    	return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

}
