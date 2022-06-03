package dto.recipe;

public class AddRecipeRequest {
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
	public AddRecipeRequest(String name, String descr, String imageUrl, int userId) {
		super();
		Name = name;
		Descr = descr;
		ImageUrl = imageUrl;
		UserId = userId;
	}
	public AddRecipeRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

}
