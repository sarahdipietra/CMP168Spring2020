

public class Food {

	private String name;
	private int calories;
	
	public Food(String name, int calories) {
		this.name = name;
		this.calories = calories;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setCalories(int calories) {
		this.calories = calories;
	}
	
	public int getCalories() {
		return calories;
	}
	
	public java.lang.String toString() {
		String s = String.format("Food - name: %10s | calories: %4d", name, calories);
		return s;
	}
	
	public boolean equals(Object o) {
		if (o instanceof Food) {
			Food nomnom = (Food)o;
			if (this.name == nomnom.name && this.calories == nomnom.calories) {
				return true; 
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
}
