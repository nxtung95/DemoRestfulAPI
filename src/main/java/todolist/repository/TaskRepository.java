package todolist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import todolist.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
	List<Task> findAllByUserId(Integer userId);
}
