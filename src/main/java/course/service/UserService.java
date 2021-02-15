package course.service;

import course.dto.UserRequestDto;
import course.dto.UserResponseDto;

public interface UserService {
	
    public UserResponseDto saveUser(UserRequestDto userDto);
}
