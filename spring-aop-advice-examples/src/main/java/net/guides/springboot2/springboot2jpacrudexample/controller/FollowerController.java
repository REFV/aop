package net.guides.springboot2.springboot2jpacrudexample.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
import net.guides.springboot2.springboot2jpacrudexample.model.Follower;
import net.guides.springboot2.springboot2jpacrudexample.service.FollowerService;

@RestController
@RequestMapping("/api/v1")
public class FollowerController {
	@Autowired
	private FollowerService followerService;

	@GetMapping("/followers")
	public List<Follower> getAllFollowers() {
		return followerService.getAllFollowers();
	}

	@GetMapping("/followers/{id}")
	public ResponseEntity<Follower> getFollowerById(@PathVariable(value = "id") Long followerId)
			throws ResourceNotFoundException {
		Follower follower = followerService.getFollowerById(followerId)
				.orElseThrow(() -> new ResourceNotFoundException("Follower not found for this id :: " + followerId));
		return ResponseEntity.ok().body(follower);
	}

	@PostMapping("/followers")
	public Follower createFollower(@Valid @RequestBody Follower follower) {
		return followerService.addFollower(follower);
	}

	@PutMapping("/followers/{id}")
	public ResponseEntity<Follower> updateFollower(@PathVariable(value = "id") Long followerId,
			@Valid @RequestBody Follower followerDetails) throws ResourceNotFoundException {
		Follower updatedFollower = followerService.updateFollower(followerId, followerDetails);
		return ResponseEntity.ok(updatedFollower);
	}

	@DeleteMapping("/followers/{id}")
	public Map<String, Boolean> deleteFollower(@PathVariable(value = "id") Long followerId)
			throws ResourceNotFoundException {
		return followerService.deleteFollower(followerId);
	}
}
