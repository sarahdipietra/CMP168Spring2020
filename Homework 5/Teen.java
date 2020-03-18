
public class Teen extends Person implements Mover{

	@Override
	public double metabolizeAccumulatedCalories() {
		double weightGained = 0;
		int calories = this.getCaloriesAccumulator();
		while (calories - 5000 >= 0) {
			weightGained++;
			this.gainWeight();
			calories = calories - 5000;
		}
		if (calories < 5000) {
			double frac = calories / 5000.00;
			this.gainWeight(frac);
		}
		this.setCaloriesAccumulator(0);
		return weightGained;
	}
	
	@Override
	public void eat(Food food) {
		int foodCals = food.getCalories();
		
		int calsConsumed = this.getCaloriesConsumed();
		this.setCaloriesConsumed(calsConsumed + foodCals);
		
		int calsAccumulated = this.getCaloriesAccumulator();
		this.setCaloriesAccumulator(calsAccumulated + foodCals);
	}
	
	@Override
	public void eat(Food[] food) {
		int totalCaloriesAdded = 0;
		for (Food nomnom : food) {
			totalCaloriesAdded = totalCaloriesAdded + nomnom.getCalories();
		}
		
		int caloriesConsumed = this.getCaloriesConsumed();
		this.setCaloriesConsumed(caloriesConsumed + totalCaloriesAdded);
		
		int caloriesAccumulated = this.getCaloriesAccumulator();
		this.setCaloriesAccumulator(caloriesAccumulated + totalCaloriesAdded);
	}

	@Override
	public String move() {
		return "run fast and jump";
	}
	
	@Override
	public String move(int count) {
		String movement = "";
		while (count > 1) {
			String mvmnt = "run fast and jump\n";
			movement = movement + mvmnt;
			count--;
		}
		movement = movement + "run fast and jump";
		return movement;
	}

}
