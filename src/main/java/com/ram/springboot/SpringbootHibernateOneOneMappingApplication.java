package com.ram.springboot;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ram.springboot.entity.Gender;
import com.ram.springboot.entity.User;
import com.ram.springboot.entity.UserProfile;
import com.ram.springboot.repository.UserProfileRepository;
import com.ram.springboot.repository.UserRepository;

// CommandLineRunner provides a Run Method

@SpringBootApplication
public class SpringbootHibernateOneOneMappingApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootHibernateOneOneMappingApplication.class, args);
	}
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserProfileRepository userProfileRepository;

	@Override
	public void run(String... args) throws Exception {
		// Create a User object
		User user = new User();
		user.setName("Huskey");
		user.setEmail("huskey@yahoo.com");
		
		UserProfile userProfile = new UserProfile();
		userProfile.setAddress("Pune");
		userProfile.setDateOfBirth(LocalDate.of(1911, 1, 11));
		userProfile.setGender(Gender.MALE);
		userProfile.setPhoneNumber("1234567899");
		// Add reference of UserProfile to User object and vice versa
		user.setUserProfile(userProfile);
		userProfile.setUser(user);
		
		userRepository.save(user);
	}

}
