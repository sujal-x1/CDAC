import java.util.HashMap;

public class Maps{
    public static void main(String[]args){

        HashMap<String,Integer> empIds = new HashMap<>();
        empIds.put("John",1232);
        empIds.put("jerru",55);
        System.out.println(empIds);
        
        System.out.println(empIds.get("jerru"));
        
    }
}