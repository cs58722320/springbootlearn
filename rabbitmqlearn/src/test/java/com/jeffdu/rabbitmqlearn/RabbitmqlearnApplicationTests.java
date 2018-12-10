package com.jeffdu.rabbitmqlearn;

import com.jeffdu.rabbitmqlearn.direct.SimpleSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqlearnApplicationTests {

	@Autowired
	private SimpleSender sender;

	@Test
	public void simpleSenderTest() {
		sender.send();
	}

}
