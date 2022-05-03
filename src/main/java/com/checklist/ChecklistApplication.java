package com.checklist;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.checklist.constances.Constances.ItemStatus;
import com.checklist.constances.Constances.UserRole;
import com.checklist.models.Checklist;
import com.checklist.models.ChecklistItem;
import com.checklist.models.User;
import com.checklist.services.impl.ChecklistItemServiceImpl;
import com.checklist.services.impl.ChecklistServiceImpl;
import com.checklist.services.impl.UserServiceImpl;

@SpringBootApplication
@ComponentScan({ "com.checklist" })
@EnableJpaRepositories
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
public class ChecklistApplication {

	@Autowired
	private ChecklistServiceImpl checklistService;
	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private ChecklistItemServiceImpl checklistItemService;

	public static void main(String[] args) {
		SpringApplication.run(ChecklistApplication.class, args);
	}

	@PostConstruct
	public void init() {
		List<User> users = new ArrayList<User>();
		List<ChecklistItem> checklistItems = new ArrayList<ChecklistItem>();
		for (int i = 0; i < 10; i++) {
			User user = new User("Nguyen", "Van A" + i, new Date(1997, 5, i), "url..." + i, "Eng 1", "Group 1",
					UserRole.STANDARD_USER);
			ChecklistItem checklistItem = new ChecklistItem("Item " + (i + 1), "Item description " + (i + 1), ItemStatus.NOT_YET);
			users.add(user);
			checklistItems.add(checklistItem);
			userService.save(users.get(i));
			checklistItemService.save(checklistItems.get(i));
		}
		Set<User> hashSet = new HashSet<User>(users);
		for (int i = 0; i < 3; i++) {
			checklistService.save(new Checklist(users, "Checklist title " + (i + 1), "Checklist description " + (i + 1),
					ItemStatus.NOT_YET, new Date(), null, 1, users.get(0), checklistItems));
		}
	}
}
