package course.service;


import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import course.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailService {
	private final UserRepository userRepository;
	
//	@Transactional(readOnly = true)
//	public boolean checkExistEmail(String email) {
//		String existEmail = userRepository.findByEmail(email);
//		return existEmail == null;
//	}
	
	@Transactional(readOnly = true)
	public boolean checkExistEmail(String email) {
		Optional<String> optionalEmail = Optional.ofNullable(userRepository.findByEmail(email));
		return optionalEmail.isPresent();
	}
}
