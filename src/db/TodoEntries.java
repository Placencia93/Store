package db;

public class TodoEntries {

	int id;
	String post;
	int track;
	
	TodoEntries(){
		
	}

	public TodoEntries(int int1, String string, int int2) {
		this.id = int1;
		this.post = string;
		this.track = int2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public int getTrack() {
		return track;
	}

	public void setTrack(int track) {
		this.track = track;
	}
	
	
}
