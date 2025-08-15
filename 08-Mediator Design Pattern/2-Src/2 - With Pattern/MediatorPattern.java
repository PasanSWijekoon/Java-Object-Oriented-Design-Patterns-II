import java.util.ArrayList;
import java.util.List;



//mediator interface
interface Mediatorinterface{
    void sendMessage(String message, User sender);
    void addUser(User user);
}

//concreate mediator

class ChatRoom implements Mediatorinterface{
    
    private List<User> users = new ArrayList<>();
            

    @Override
    public void sendMessage(String message, User sender) {
        for (User user : users) {
            if(user != sender){
                user.receive(message , sender.getName());
            }
            
        }
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }
    
}

//coleguie

class User{
    
    private String name;
    private Mediatorinterface mediator;

    public User(String name, Mediatorinterface mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public String getName() {
        return name;
    }

    public void send(String message) {
        mediator.sendMessage(message, this);
    }

    public void receive(String message ,String senderName ) {
         System.out.println(senderName + " to " +name+ " : " + message);
    }
    

     
    
}

public class MediatorPattern {
    
    public static void main(String[] args) {
        
        ChatRoom chat = new ChatRoom();
        
        User pasan = new User("pasan",chat);
        User hasindu = new User("Hasindu",chat);
        User janith = new User("Janith",chat);
        
        chat.addUser(pasan);
        chat.addUser(hasindu);
        chat.addUser(janith);
        
        
        pasan.send("Hello");    
        janith.send("Welcum");
            
    }
    
}
