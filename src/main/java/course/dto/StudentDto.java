package course.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class StudentDto {
	@ApiModelProperty(name = "student year", example = "2020")
	private int year;
}
