package todolist.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import todolist.dto.TaskDto;
import todolist.entity.Task;
import todolist.repository.TaskRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public List<TaskDto> getTasks(Integer userId) {
    	System.out.println(userId);
        List<Task> tasks = taskRepository.findAllByUserId(userId);
        return tasks
                .stream()
                .map(task -> modelMapper.map(task, TaskDto.class))
                .collect(Collectors.toList());
    }

//    @Transactional(readOnly = true)
//    public TaskDto getTask(Integer taskId) {
//        Task task = taskRepository.findById(taskId)
//                .orElseThrow(() -> new RuntimeException(String.format("Task not found: #%s", taskId)));
//        return modelMapper.map(task, TaskDto.class);
//    }
//
//    @Transactional
//    public TaskDto saveTask(TaskDto taskDto) {
//        Task task;
//        if (Objects.isNull(taskDto.getId())) {
//            task = new Task();
//        } else {
//            task = taskRepository.findById(taskDto.getId())
//                    .orElseThrow(() -> new RuntimeException(String.format("Task not found: #%s", taskDto.getId())));
//        }
//        modelMapper.map(taskDto, task);
//        Task savedTask = taskRepository.save(task);
//        return modelMapper.map(savedTask, TaskDto.class);
//    }
//
//    @Transactional
//    public void deleteTask(Integer taskId) {
//        Task task = taskRepository.findById(taskId)
//                .orElseThrow(() -> new RuntimeException(String.format("Task not found: #%s", taskId)));
//        taskRepository.delete(task);
//    }

}
