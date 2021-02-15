package course.service;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import course.dto.UserRequestDto;
import course.dto.UserResponseDto;
import course.entity.Student;
import course.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

@Service
@RequiredArgsConstructor
public class StudentService implements UserService {

	private final ModelMapper modelMapper;
	private final StudentRepository studentRepository;
	
	@Override
	@Transactional
	public UserResponseDto saveUser(UserRequestDto userRequestDto) {
		Student student = new Student();
		modelMapper.map(userRequestDto.getStudent(), student);
		student.setName(userRequestDto.getName());
		student.setEmail(userRequestDto.getEmail());
		student.setPassword(userRequestDto.getPassword());
		Student saveStudent = studentRepository.save(student);
		
		return modelMapper.map(saveStudent, UserResponseDto.class);
	}

}
