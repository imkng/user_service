package com.multiclient.userservice;

import com.multiclient.userservice.dao.CustomerRepository;
import com.multiclient.userservice.entity.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class UserServiceApplicationTests {
	@Autowired
	CustomerRepository customerRepository;
	@Test
	void testAddCustomer() {
		Users users=new Users();
		users.setUserId(1);
		users.setUserName("abc");
		users.setAddress("banglore");
		users.setEmail("abc@gmail.com");
		users.setMobileNumber(345678987);
		users.setPassword("abc@123");
		customerRepository.save(users);

	}

}
