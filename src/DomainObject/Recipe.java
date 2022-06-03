package DomainObject;

import java.util.Date;

import javafx.scene.image.Image;

public class Recipe {
	int Id;
	String Name;
	String Descr;
	String ImageUrl;
	int UserId;
	Date createdAt;
	Image image;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDescr() {
		return Descr;
	}
	public void setDescr(String descr) {
		Descr = descr;
	}
	public String getImageUrl() {
		return ImageUrl;
	}
	public void setImageUrl(String imageUrl) {
		ImageUrl = imageUrl;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Image getImage() {
		Image image = new Image(this.ImageUrl);
		return image;
	}
	public Recipe(int id, String name, String descr, String imageUrl, int userId, Date createdAt) {
		super();
		Id = id;
		Name = name;
		Descr = descr;
		ImageUrl = imageUrl;
		UserId = userId;
		this.createdAt = createdAt;
		
	}
	public Recipe() {

	}
	@Override
	public String toString() {
		return Name;
	}
	
	
}
