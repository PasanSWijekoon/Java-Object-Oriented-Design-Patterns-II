
interface Coffee{    
    double cost();
    String description();
}

class SimpleCofee implements Coffee{

    @Override
    public double cost() {
        return 500;
    }
    
    @Override
    public String description() {
        return "Simple Cofee"; 
    }           
}

abstract class CofeeDecorator implements Coffee{   
    
    protected Coffee cofee;
    
    public CofeeDecorator(Coffee cofee){
        this.cofee = cofee;
    }
}

class MilkDecorator extends CofeeDecorator{
    
    public MilkDecorator(Coffee cofee){
        super(cofee);
    }
    

    @Override
    public double cost() {
        return cofee.cost()+100;
    }

    @Override
    public String description() {
        return cofee.description()+" Milk"; 
    }
     
}

class SugarDecorator extends CofeeDecorator{
    
    public SugarDecorator(Coffee cofee){
        super(cofee);
    }
    

    @Override
    public double cost() {
        return cofee.cost()+50;
    }

    @Override
    public String description() {
        return cofee.description()+" Suger"; 
    }
     
}

public class Decorator {

    public static void main(String[] args) {
        
        Coffee cofee = new SimpleCofee();
        
        cofee = new MilkDecorator(cofee);
        cofee = new SugarDecorator(cofee);
        
        System.out.println("Cost" +cofee.cost());
        System.out.println("Description" +cofee.description());
        
   
    }
    
}
