package Final;

public class ListEntry {

	int id;
	String title;
	String link;
	int count;
	
	ListEntry(int id, String title, String link, int count){
		this.id = id;
		this.title = title;
		this.link = link;
		this.count = count;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
}
