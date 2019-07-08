package ru.jihor.example

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import ru.jihor.example.service.ExampleService

@RunWith(SpringRunner::class)
@SpringBootTest
class ExampleServiceApplicationTests {

	@Autowired
	lateinit var exampleService: ExampleService

	@Test
	fun contextLoads() {
		Assert.assertNotNull(exampleService)
	}

}
