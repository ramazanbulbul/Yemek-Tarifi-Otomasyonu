package dto.recipe;

public class EditRecipeRequest {
	int Id;
	String Name;
	String Descr;
	String ImageUrl;
	int UserId;
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
	public void setId(int id) {
		Id = id;
	}
	public int getId() {
		return Id;
	}
	public EditRecipeRequest(int id, String name, String descr, String imageUrl, int userId) {
		super();
		Id = id;
		Name = name;
		Descr = descr;
		ImageUrl = imageUrl;
		UserId = userId;
	}
	public EditRecipeRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
}
