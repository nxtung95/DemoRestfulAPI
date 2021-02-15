package course.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import course.error.ErrorCode;
import course.error.ErrorMessage;
import course.mode.UserMode;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserRequestDto {
	@NotEmpty(message = ErrorCode.USER_E001 + ":" + ErrorMessage.USER_E001)
	@ApiModelProperty(value = "user name", example = "Nguyen van C", required = true)
	private String name;
	
	@NotEmpty(message = ErrorCode.USER_E002 + ":" + ErrorMessage.USER_E002)
	@ApiModelProperty(value = "password", example = "Test1234", required = true)
	private String password;
	
	@NotEmpty(message = ErrorCode.USER_E003 + ":" + ErrorMessage.USER_E003)
//	@EmailExistsConstraint(message = ErrorCode.USER_E004 + ":" + ErrorMessage.USER_E004)
	@ApiModelProperty(value = "email", example = "tungnx@luvina.net", required = true)
	private String email;
	
	@ApiModelProperty(name = "student")
	private StudentDto student;
	
	@ApiModelProperty(name = "teacher", hidden = true)
	private TeacherDto teacher;
	
	@NotNull(message = ErrorCode.USER_E005 + ":" + ErrorMessage.USER_E005)
	@ApiModelProperty(name = "mode user", example = "STUDENT", required = true)
	private UserMode mode;
}
