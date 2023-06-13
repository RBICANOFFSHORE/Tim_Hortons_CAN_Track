package json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import models.Item;
 
public class JsonReader 
{
    @SuppressWarnings("unchecked")
    public Item readItemJsonFile() 
    {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
         
        try (FileReader reader = new FileReader(".\\TestDataSet\\itemsArray.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            JSONArray itemsList = (JSONArray) obj;
             
            //Iterate over employee array
            //itemsList.forEach( ( item )-> parseItems( (JSONObject) item ) );
            
            for(Object item : itemsList){
            	JSONObject item1= (JSONObject) item;
            	
            	try {
        			//Get employee object within list
        			JSONObject employeeObject = (JSONObject) item1.get("item");
        			String category = (String) employeeObject.get("category");    			
        			String price = (String) employeeObject.get("price");
        			String item_name = (String) employeeObject.get("item_name");		
        			String sub_category = (String) employeeObject.get("sub_category");			
        			String size = (String) employeeObject.get("size");
        			
        			System.out.println(item_name);
        		} catch (Exception e) {
        		
        			e.printStackTrace();
        			
        		}
            }
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
		return null;
    }
 
}