package com.projectincedoplay.reglog;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectincedoplay.reglog.UserEntitya.User;
import com.projectincedoplay.reglog.UserPojo.UserPojo;
import com.projectincedoplay.reglog.UserRepository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public String saveUser(UserPojo userPojo) {

		Optional<User> email = userRepository.findByEmailId(userPojo.getEmail());

		if (!email.isPresent()) {

			User user = new User();
			user.setName(userPojo.getName());
			user.setEmailId(userPojo.getEmail());
			user.setPassword(userPojo.getPassword());
			userRepository.save(user);
			return "Successfully Entered";

		}

		else {
			return "This email is already register";

		}

	}

	@Override
	public List<User> getUser() {
		List<User> getData = userRepository.findAll();
		return getData;
	}

	@Override
	public Optional<User> findByEmailid(String email) {
		// TODO Auto-generated method stub

		Optional<User> Emailid = userRepository.findByEmailId(email);
		return Emailid;
	}

	@Override
	public String authenticate(UserPojo userPojo) {
		// TODO Auto-generated method stub
		User user  = userRepository.findByEmailIdAndPassword(userPojo.getEmail(), userPojo.getPassword() ) ;
		if(user==null) {
			return "Invalid Credentials";
			
		} else {
			return "Welcome "+user.getName();
		}
	}

}
