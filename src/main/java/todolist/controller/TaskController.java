package todolist.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import todolist.dto.TaskDto;
import todolist.service.TaskService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/api/v1/users/{userId}/tasks")
    public ResponseEntity<List<TaskDto>> getTasks(@PathVariable(value = "userId") Integer userId) {
        List<TaskDto> response = taskService.getTasks(userId);
        System.out.println(response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

//    @GetMapping("/api/v1/tasks/{taskId}")
//    public ResponseEntity<TaskDto> getTask(@PathVariable(value = "taskId") Integer taskId) {
//        TaskDto response = taskService.getTask(taskId);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//
//    @PostMapping("/api/v1/tasks")
//    public ResponseEntity<TaskDto> createTask(@Valid @RequestBody TaskDto taskDto) {
//        TaskDto response = taskService.saveTask(taskDto);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//
//    @PutMapping("/api/v1/tasks")
//    public ResponseEntity<TaskDto> updateTask(@Valid @RequestBody TaskDto taskDto) {
//        TaskDto response = taskService.saveTask(taskDto);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/api/v1/tasks/{taskId}")
//    public ResponseEntity<Void> deleteTask(@PathVariable(value = "taskId") Integer taskId) {
//        taskService.deleteTask(taskId);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
}
