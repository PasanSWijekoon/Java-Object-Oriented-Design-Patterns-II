import java.util.ArrayList;
import java.util.List;



interface ATCTower{
    
    void requestToTakeOff(Plane plane);
    void requestToLand(Plane plane);
    void registerplane(Plane plane);
    
}

class Controller implements ATCTower{
    
    private List<Plane> planes = new ArrayList<>();

    @Override
    public void requestToTakeOff(Plane requestingplane) {
        for (Plane allplanes : planes) {
            if(allplanes != requestingplane){
                 allplanes.NotifyATC(requestingplane.getName()+ " Requesting to Take off");
            }
            
        }
       
    }

    @Override
    public void requestToLand(Plane requestingplane) {
          for (Plane allplanes : planes) {
            if(allplanes != requestingplane){
                 allplanes.NotifyATC(requestingplane.getName()+ " Requesting to Land");
            }
            
        }   
    }

    @Override
    public void registerplane(Plane plane) {
        planes.add(plane);
    }
       
}


interface Plane{  
    void takeoff();
    void land();
    void NotifyATC(String message);   
    String getName();
}


class Airplane implements Plane{
    
    private String name;
    private ATCTower mediator;

    public Airplane(String name, ATCTower mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public String getName() {
        return name;
    }
    
    @Override
    public void takeoff() {
        
        mediator.requestToTakeOff(this);
    }

    @Override
    public void land() {
        mediator.requestToLand(this);
    }

    @Override
    public void NotifyATC(String message) {   
        System.out.println(name+ " : " + message);
    }
   
}





public class Mediatorquiz {

    
    public static void main(String[] args) {
        
        ATCTower tower = new Controller();
        
        Plane plane1 = new Airplane("Quter AirBus 2102",tower);
        Plane plane2 = new Airplane("AirIndia AirBus 1345",tower);
        Plane plane3 = new Airplane("Srilanka AirBus 22",tower);
        
        tower.registerplane(plane1);
        tower.registerplane(plane2);
        tower.registerplane(plane3);
        
        plane1.land();
        plane2.takeoff();
        
        plane3.NotifyATC("Plane 3 Taxiing");
        
    }
    
}
