package comd.davis.course;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) throws InterruptedException {
		
		final List<String> ingredients = new ArrayList<String>() {
			{
				add("cheese"); 
				add("tomato");
			}
		};
		
		final Product product = new Product("Pizza", 123, ingredients);
		
		System.out.println("The ingredients are " + product.getIngredientIds());
		
		// I try to change the ingredients
		ingredients.add("chilli");
		
		// The pizza is safe... because it's immutable!!!
		System.out.println("After attempted tampering, the ingredients are " + product.getIngredientIds());	
	}
}
