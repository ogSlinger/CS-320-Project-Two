import java.lang.String;

public class Task {
	private String id = new String();
	private String name = new String();
	private String description = new String();
	
	//Constructor
	public Task () {
		this.id = "Default";
		this.name = "Default";
		this.description = "Default";
	}
	
	//Setters
	public void setId (String Id) {
		if (this.id.equals("Default")) {
			this.id = (Id.length() < 11 && Id.length() > 0) ? Id : this.id; 
		}
	}
	
	public void setName (String name) { 
		this.name = (name.length() < 21 && name.length() > 0) ? name : this.name; 
	}
	
	public void setDescription (String description) { 
		this.description = (description.length() < 51 && description.length() > 0) ? description : this.description; 
	}
	
	//Getters
	public String getId() { return this.id; }
	public String getName() { return this.name; }
	public String getDescription() { return this.description; }
}
