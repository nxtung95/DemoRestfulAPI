package course.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserResponseDto {
	@ApiModelProperty(name = "name", example = "Nguyen van C")
	private String name;
	@ApiModelProperty(name = "email", example = "tungnx@luvina.net")
	private String email;
}
