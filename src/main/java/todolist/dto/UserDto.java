package todolist.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class UserDto {
	private Integer id;
	@NotBlank
	private String name;
	@NotBlank
	private String password;
	@NotBlank
	private String email;
}
