package com.jlcindiabookstore;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@SpringBootApplication
public class JLCBookSearchConfig implements WebMvcConfigurer {
	// BookSearch Exchange
	@Bean(name = "myBookSearchExchange")
	Exchange createBookSearchExchange() {
	return ExchangeBuilder.topicExchange("mybook.search.exchange").build();
	}
	// BookRating Message
	//A. BookRating Queue
	@Bean(name = "myBookRatingsQueue")
	Queue createBookRatingsQueue() {
	return QueueBuilder.durable("mybook.ratings.queue").build();
	}
	//B. BookRating Binding
	@Bean
	Binding bookRatingBinding(Queue myBookRatingsQueue, TopicExchange myBookSearchExchange) {
	return BindingBuilder.bind(myBookRatingsQueue)
	.to(myBookSearchExchange)
	.with("mybook.ratings.key");
	}
	// BookInventory Message
	//A. BookInventory Queue
	@Bean(name = "myInventoryQueue")
	Queue createInventoryQueue() {
	return QueueBuilder.durable("myinventory.queue").build();
	}
	//B. BookInventory Binding
	@Bean
	Binding inventoryBinding(Queue myInventoryQueue, TopicExchange myBookSearchExchange) {
	return BindingBuilder.bind(myInventoryQueue)
	.to(myBookSearchExchange)
	.with("myinventory.key");
	}
	


}
