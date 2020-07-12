package comd.davis.course;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Product {

	private final String name;
	private final int code;
	private final List<String> ingredients;

	public Product(String name, int code, List<String> ingredients) {
		this.name = name;
		this.code = code;
		this.ingredients = new ArrayList<String>(ingredients);
	}

	public String getName() { 
		return this.name;
	}

	public int getCode() {
		return this.code;
	}

	public List<String> getIngredientIds() {
		return Collections.unmodifiableList(ingredients);
	}
}