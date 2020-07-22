package comd.davis.course;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) throws InterruptedException {
		
		final List<String> ingredients = new ArrayList<>() {
			{
				add("cheese"); 
				add("tomato");
			}
		};
		
		final Product product = new Product("Pizza", 123, ingredients);
		
		System.out.println("The ingredients are " + product.getIngredients());
		
		// I try to change the ingredients
		product.getIngredients().add("chilli");
		
		// The pizza is safe... because it's immutable!!!
		System.out.println("After attempted tampering, the ingredients are " + product.getIngredients());	
	}
}
