package todolist.dto;

import lombok.Data;
import todolist.entity.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class TaskDto {

    private Integer id;

    @NotBlank
    private String title;

    @NotNull
    private Integer priority;
    
    @NotNull
    private User user;

}
