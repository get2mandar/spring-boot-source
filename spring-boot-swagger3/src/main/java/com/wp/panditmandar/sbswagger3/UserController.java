package com.wp.panditmandar.sbswagger3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wp.panditmandar.sbswagger3.exception.ResourceNotFoundException;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/v1")
@OpenAPIDefinition(info = @Info(title = "Users API", version = "2.0", description = "Users Information"))
public class UserController {

	@Autowired
	private UserService userService;

	@Operation(summary = "View a List of available Users", tags = { "User API" }, responses = {
			@ApiResponse(responseCode = "200", description = "Successfully Retrieved List", content = @Content(schema = @Schema(implementation = List.class))),
			@ApiResponse(responseCode = "401", description = "You are not Authorized to View the Resource", content = @Content),
			@ApiResponse(responseCode = "403", description = "Accessing the Resource you were trying to reach is forbidden", content = @Content),
			@ApiResponse(responseCode = "404", description = "The Resource you were trying to Reach is Not Found", content = @Content) })
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@Operation(summary = "Get User by an ID", tags = { "User API" })
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(
			@Parameter(description = "User Id to retrieve the User Object", required = true) @PathVariable(value = "id") Long userID)
			throws ResourceNotFoundException {
		User user = userService.getUserByID(userID)
				.orElseThrow(() -> new ResourceNotFoundException("User Not Found for the ID: " + userID));
		return ResponseEntity.ok().body(user);
	}

	@Operation(summary = "Add New User Object", tags = { "User API" })
	@PostMapping("/users")
	public User createUser(
//			@Parameter(description = "Save User Object in Database Table", required = true)
			@Parameter(required = true) @RequestBody User User) {
		return userService.saveUser(User);
	}

	@Operation(summary = "Update an User", tags = { "User API" })
	@PutMapping("/users")
	public ResponseEntity<User> updateUser(
//			@Parameter(description = "User Object to Update", required = true)
			@Parameter(required = true) @RequestBody User userDetail) throws ResourceNotFoundException {
		final User updatedUser = userService.updateUser(userDetail)
				.orElseThrow(() -> new ResourceNotFoundException("User Not Found for the ID: " + userDetail.getId()));
		return ResponseEntity.ok(updatedUser);
	}

	@Operation(summary = "Delete an User", tags = { "User API" })
	@DeleteMapping("/users/{id}")
	public Map<String, Boolean> deleteUser(
			@Parameter(description = "User ID from which the User Object will be deleted from Database", required = true) @PathVariable(value = "id") Long UserID)
			throws ResourceNotFoundException {
		User user = userService.getUserByID(UserID)
				.orElseThrow(() -> new ResourceNotFoundException("User Not Found for the ID: " + UserID));

		userService.deleteUser(user);

		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
