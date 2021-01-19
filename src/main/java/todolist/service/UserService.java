package todolist.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import todolist.dto.UserDto;
import todolist.entity.User;
import todolist.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;
	private final ModelMapper modelMapper;
	
	@Transactional(readOnly = true)
	public List<UserDto> getUsers() {
		List<User> users = userRepository.findAll();
        return users
                .stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public UserDto getUser(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException(String.format("User not found: #%s", userId)));
        return modelMapper.map(user, UserDto.class);
	}
	
    @Transactional
    public UserDto saveUser(UserDto userDto) {
        User user;
        if (Objects.isNull(userDto.getId())) {
        	user = new User();
        } else {
        	user = userRepository.findById(userDto.getId())
                    .orElseThrow(() -> new RuntimeException(String.format("User not found: #%s", userDto.getId())));
        }
        modelMapper.map(userDto, user);
        User saveUser = userRepository.save(user);
        return modelMapper.map(saveUser, UserDto.class);
    }
    
    @Transactional
    public void deleteUser(Integer userId) {
    	User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException(String.format("User not found: #%s", userId)));
    	userRepository.delete(user);
    }
}
