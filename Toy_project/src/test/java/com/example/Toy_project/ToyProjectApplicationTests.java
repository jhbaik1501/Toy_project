package com.example.Toy_project;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ToyProjectApplicationTests {

	@Test
	void insert쿼리테스트() {
		EnvironRepositoryImp environRepositoryImp = new EnvironRepositoryImp();
		environRepositoryImp.saveEnvironment(null);
	}

}
