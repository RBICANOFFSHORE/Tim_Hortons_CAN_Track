package json;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
 
public class JsonWriter
{
    @SuppressWarnings("unchecked")
	public static void main( String[] args )
    {
        //First Employee
        JSONObject itemDetails = new JSONObject();
        itemDetails.put("category", "Breakfast");
        itemDetails.put("price", "3.59");
        itemDetails.put("sub_category", "");
        itemDetails.put("size", "");
        itemDetails.put("item_name", "Sausage, Egg & Cheese Breakfast Sandwich");
        //itemDetails.put("default_build", "Sausage, Egg & Cheese Breakfast Sandwich");
        //itemDetails.put("mods", "Sausage, Egg & Cheese Breakfast Sandwich");
         
        JSONObject item = new JSONObject(); 
        item.put("item", itemDetails);
         
        //Second Item
        JSONObject itemDetails2 = new JSONObject();
        itemDetails2.put("category", "Cold Beverages");
        itemDetails2.put("price", "3.09");
        itemDetails2.put("sub_category", "");
        itemDetails2.put("size", "Small");
        itemDetails2.put("item_name", "Iced Capp");
         
        JSONObject item2 = new JSONObject(); 
        item2.put("item", itemDetails2);
        
        //Third Item
        JSONObject itemDetails3 = new JSONObject();
        itemDetails3.put("category", "Baked Goods");
        itemDetails3.put("price", "1.79");
        itemDetails3.put("sub_category", "Muffins");
        itemDetails3.put("size", "");
        itemDetails3.put("item_name", "Chocolate Chip Muffin");
         
        JSONObject item3 = new JSONObject(); 
        item3.put("item", itemDetails3);
         
        //Add items to list
        JSONArray employeeList = new JSONArray();
        employeeList.add(item);
        employeeList.add(item2);
        employeeList.add(item3);
         
        //Write JSON file
        try (FileWriter file = new FileWriter(".\\TestDataSet\\itemsArray.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(employeeList.toJSONString()
            		); 
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}