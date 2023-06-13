package models;

public class Item {
	
	String item_name;
	String size;
	String sub_category;
	String price;
	String category;
	String region;
	
	public Item(String item_name, String size, String sub_category, String price, String category, String region) {
		super();
		this.item_name = item_name;
		this.size = size;
		this.sub_category = sub_category;
		this.price = price;
		this.category = category;
		this.region = region;
	}

	public String getItem_name() {
		return item_name;
	}

	public String getSize() {
		return size;
	}

	public String getSub_category() {
		return sub_category;
	}

	public String getPrice() {
		return price;
	}

	public String getCategory() {
		return category;
	}
	
	
	public String getRegion(){
		return region;
	}
	
	
	

}
