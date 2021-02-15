package course.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TeacherDto {
	@ApiModelProperty(name = "teacher phone", example = "0123456789")
	private String phone;
	@ApiModelProperty(name = "experiences", example = "4")
	private int experiences;
}
