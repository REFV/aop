package net.guides.springboot2.springboot2jpacrudexample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "followers")
public class Follower {

	private long id;
	private String followerName;
	
	private String url;
	
	public Follower() {
		
	}
	
	public Follower(String Name, String url) {
		this.followerName = followerName;
		
		this.url = url;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "follower_name", nullable = false)
	public String getFollowerName() {
		return followerName;
	}
	public void setFollowerName(String followerName) {
		this.followerName = followerName;
	}
	
	
	
	@Column(name = "url", nullable = false)
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Follower [id=" + id + ", followerName=" + followerName + ", url=" + url
				+ "]";
	}
	
}
