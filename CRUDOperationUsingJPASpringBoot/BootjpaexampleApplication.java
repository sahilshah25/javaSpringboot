package com.jpa.demo;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BootjpaexampleApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context= SpringApplication.run(BootjpaexampleApplication.class, args);
		
		
		
		
		//Saving the data
		UserRepository userRepository=context.getBean(UserRepository.class);
		/*
		User user1=new User();
		user1.setName("shah");
		user1.setCity("haryana");
		user1.setStatus("devloper");
		 
		User user2=new User();
		user2.setName("ahmad");
		user2.setCity("uk");
		user2.setStatus("backend");
		
		List<User> temp=List.of(user1,user2);
		
		
		Iterable<User> re=userRepository.saveAll(temp);
		re.forEach(user->{
			System.out.println(user);
		});
		
		System.out.println("done");*/
		
		
		//update the user of id 152
		
		/*Optional<User> optional=userRepository.findById(152);
		
		User user=optional.get();
		user.setName("sahil ahmad shah");
		User result= userRepository.save(user);
		System.out.println(result);*/
		
		Iterable<User > itr= userRepository.findAll();
		/*
		Iterator<User> iterator=itr.iterator();
		while( iterator.hasNext()) {
			User user=iterator.next();
			System.out.println(user);
			
		}*/
		/*itr.forEach(new Consumer<User>() {

			@Override
			public void accept(User t) {
				System.out.println(t);
				
				
			}
		});*/
		
		
		//itr.forEach(user->System.out.println(user));
		
		
		//deleting the user element
		
		/*userRepository.deleteById(152);
		System.out.println("deleted");
		*/
		
		
		Iterable<User > alluser=userRepository.findAll();
		alluser.forEach(user->System.out.println(user));
		
		userRepository.deleteAll(alluser);
		
		
		
		
		
		
	}

}
