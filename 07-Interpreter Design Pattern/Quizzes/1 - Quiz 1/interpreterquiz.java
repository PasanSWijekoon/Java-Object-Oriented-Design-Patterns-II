

//Abstract Expression
interface Expression{
    
    void interprete(Context context);
}

//Context 
class Context{
    
    public void turnOnDevice(String device , String location){
        System.out.println(location +" "+device+ " ON");
    }
    
    public void turnOffDevice(String device, String location){
        System.out.println(location +" "+device+ " OFF");
    }
    
    public void increaseTemp(int amount){
        System.out.println( "Temprature Increased By " + amount );
    }
    
    public void decreaseTemp(int amount){
         System.out.println( "Temprature Decreased By " + amount );
    }
       
}

//Non-terminal Expressions
class DeviceCommand implements Expression{

    private String action;
    private String device;
    private String location;

    public DeviceCommand(String action, String device, String location) {
        this.action = action;
        this.device = device;
        this.location = location;
    }
      
    @Override
    public void interprete(Context context) {
        
        if (action.equalsIgnoreCase("on")){
            context.turnOnDevice(device,location);
        }else if (action.equalsIgnoreCase("off")){
            context.turnOffDevice(device,location);
        }
      
    }
    
}

//Non-terminal Expressions
class TempratureCommand implements Expression{

    private String action;
    private int value;


    public TempratureCommand(String action, int value) {
        this.action = action;
        this.value = value;
    }
      
    @Override
    public void interprete(Context context) {
        
        if (action.equalsIgnoreCase("increase")){
            context.increaseTemp(value);
        }else if (action.equalsIgnoreCase("decrease")){
            context.decreaseTemp(value);
        }
      
    }
    
}


class commandParser{
    
     public static Expression Parse(String input) {
         
         String tokens[] = input.trim().split(" ");
         
         if(tokens[0].equalsIgnoreCase("turn")){
             
             String action = tokens[1];
             String location = tokens[2];
             String device = tokens[3];
             
             return new DeviceCommand(action, device, location);
             
         }else if (tokens[0].equalsIgnoreCase("increase") || tokens[0].equalsIgnoreCase("decrease")){
             
             String action = tokens[0];
             String value = tokens[3];
             
             return new TempratureCommand(action, Integer.parseInt(value));
         }
             throw new IllegalArgumentException("Unsuppored command "+input);
     }
}



public class interpreterquiz {
    public static void main(String[] args) {
        
        Context context = new Context();
        
        Expression ex1 = commandParser.Parse("Turn on Kitchen light");
        ex1.interprete(context);
        
        
        Expression ex2 = commandParser.Parse("Turn off Bedroom light");
        ex2.interprete(context);
        
        
        Expression ex3 = commandParser.Parse("increase temprature by 5");
        ex3.interprete(context);
        
        Expression ex4 = commandParser.Parse("decrease temprature by 3");
        ex4.interprete(context);
        
        
    }
    
}
