import java.util.ArrayList;

public class User {
    private int userId = -1; // ID placeholder
    private String userName = "";
    private ArrayList<Checklist> userLists = new ArrayList<Checklist>(); // array list to hold lists?
    
    public User(){};
    
    public User (int id, String name){
        userId = id;
        userName = name;
    }
    
    public void setUserName(String name){
        userName = name;
    }
    
    public int getId(){
        return userId
;    }
    
    public String getUserName(){
        return userName;
    }
    
    public void makeChecklist(){
        Checklist newList = new Checklist(); // create new checklist
        userLists.add(newList); // add new list to array list
    }
    
    public void deleteChecklist(int index){ // how to pass index
        if (index >= 0 && index < userLists.size())
         userLists.remove(index); // remove one specific list
    }
    
    public void deleteAllChecklist(){
        userLists.clear(); // remove all lists
    }
    
}
