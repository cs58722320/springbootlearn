package com.jeffdu.rabbitmqlearn;

import com.jeffdu.rabbitmqlearn.direct.SimpleSender;
import com.jeffdu.rabbitmqlearn.route.RouteSender;
import com.jeffdu.rabbitmqlearn.subpub.NewsPublisher;
import com.jeffdu.rabbitmqlearn.worker.MessageProvider;
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

	@Autowired
	private MessageProvider messageProvider;

	@Autowired
	private NewsPublisher newsPublisher;

	@Autowired
	private RouteSender routeSender;

	@Test
	public void simpleSenderTest() {
		sender.send();
	}

	@Test
	public void messageWorkerTest() {
		messageProvider.send();
	}

	@Test
	public void pubsubTest() {
		newsPublisher.send();
	}

	@Test
	public void routeSender(){
		routeSender.send();
	}
}
