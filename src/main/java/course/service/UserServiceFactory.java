package course.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import course.error.ErrorCode;
import course.error.ErrorMessage;
import course.exception.UnsupportedUserException;
import course.mode.UserMode;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserServiceFactory {
	private final StudentService studentService;
	private final TeacherService teacherService;
	
	public UserService createUser(UserMode mode) throws Exception {
		if (UserMode.STUDENT.equals(mode)) {
			return studentService;
		} else if (UserMode.TEACHER.equals(mode)) {
			return teacherService;
		} else {
			throw new UnsupportedUserException(HttpStatus.BAD_REQUEST, ErrorCode.USER_E006, ErrorMessage.USER_E006);
		}
	}
}
