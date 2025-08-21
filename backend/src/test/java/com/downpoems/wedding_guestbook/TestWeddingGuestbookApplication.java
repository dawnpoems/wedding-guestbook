package com.downpoems.wedding_guestbook;

import org.springframework.boot.SpringApplication;

public class TestWeddingGuestbookApplication {

	public static void main(String[] args) {
		SpringApplication.from(WeddingGuestbookApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
