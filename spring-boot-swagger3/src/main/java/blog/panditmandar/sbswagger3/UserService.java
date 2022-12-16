package blog.panditmandar.sbswagger3;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	private List<User> userList = new LinkedList<>();

	public List<User> getAllUsers() {
		return userList;
	}

	public Optional<User> getUserByID(Long ID) {
		return Optional.of(userList.stream().filter(u -> u.getId() == ID).collect(toSingleton()));
	}

	public User saveUser(User user) {
		userList.add(user);
		return user;
	}

	public Optional<User> updateUser(User user) {
		Optional<User> userByID = getUserByID(user.getId());
		if (userByID.isPresent()) {
			User userFromList = userByID.get();
			userFromList.setFirstName(user.getFirstName());
			userFromList.setLastName(user.getLastName());
			userFromList.setEmailID(user.getEmailID());

			int index = userList.indexOf(userFromList);
			userList.set(index, userFromList);
			return Optional.of(userFromList);
		}
		return Optional.empty();
	}

	public void deleteUser(User user) {
		userList.remove(user);
	}

	private static <T> Collector<T, ?, T> toSingleton() {
		return Collectors.collectingAndThen(Collectors.toList(), list -> {
			if (list.size() > 0) {
				return list.get(0);
			}
			return null;
		});
	}

}
