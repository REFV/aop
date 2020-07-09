package net.guides.springboot2.springboot2jpacrudexample.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
import net.guides.springboot2.springboot2jpacrudexample.model.Follower;
import net.guides.springboot2.springboot2jpacrudexample.repository.FollowerRepository;

@Service
public class FollowerService {
	
	@Autowired
	private FollowerRepository followerRepository;
	
	public List<Follower> getAllFollowers() {
		return followerRepository.findAll();
	}

	public Optional<Follower> getFollowerById(Long followerId)
			throws ResourceNotFoundException {
		return followerRepository.findById(followerId);
	}

	public Follower addFollower(Follower follower) {
		return followerRepository.save(follower);
	}

	public Follower updateFollower(Long followerId,
			Follower followerDetails) throws ResourceNotFoundException {
		Follower follower = followerRepository.findById(followerId)
				.orElseThrow(() -> new ResourceNotFoundException("Follower not found for this id :: " + followerId));

		follower.setUrl(followerDetails.getUrl());
		follower.setFollowerName(followerDetails.getFollowerName());
		final Follower updatedFollower = followerRepository.save(follower);
		return updatedFollower;
	}
	public Map<String, Boolean> deleteFollower(Long followerId)
			throws ResourceNotFoundException {
		Follower follower = followerRepository.findById(followerId)
				.orElseThrow(() -> new ResourceNotFoundException("Follower not found for this id :: " + followerId));

		followerRepository.delete(follower);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
