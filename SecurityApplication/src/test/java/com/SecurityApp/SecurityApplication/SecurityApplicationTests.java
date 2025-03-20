package com.SecurityApp.SecurityApplication;

import com.SecurityApp.SecurityApplication.entities.User;
import com.SecurityApp.SecurityApplication.services.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SecurityApplicationTests {

	@Autowired
	private JwtService jwtService;

	@Test
	void contextLoads() {

		User user = new User(4L, "rinx@gmail.com", "123", "rin");

		String token = jwtService.generateAccessToken(user);

		System.out.println(token);

		Long id = jwtService.getUserIdFromToken("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI0IiwiZW1haWwiOiJyaW54QGdtYWlsLmNvbSIsInJvbGVzIjpbIlVTRVIiLCJBRE1JTiJdLCJpYXQiOjE3MzUxMjQ2MzksImV4cCI6MTczNTEyNDY5OX0.Un4v5hi2NBZ58Gj4Rx4_bEkIsWq4L5bfylPH_vFStM7D5RyAvAn9u9qAjuZAkypOLoRVw7PF83TfTpBAk0TvVQ");

		System.out.println(id);

	}

}
