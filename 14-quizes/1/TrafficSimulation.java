import java.util.HashMap;
import java.util.Map;

interface Vehicle {
   void render(int x, int y, double speed, double direction, double fuelLevel);
}


class VehicleModel implements Vehicle {
   
   private final String modelName;
   private final String manufacture;
   private final String[] color;
   private final String meshFile;
   private final String textureFile;

   public VehicleModel(String modelName, String manufacture, String[] color, String meshFile, String textureFile) {
       this.modelName = modelName;
       this.manufacture = manufacture;
       this.color = color;
       this.meshFile = meshFile;
       this.textureFile = textureFile;
   }

   @Override
   public void render(int x, int y, double speed, double direction, double fuelLevel) {
       System.out.println("Rendering vehicle model: " + modelName + " by " + manufacture);
       System.out.println("Position: (" + x + ", " + y + "), Speed: " + speed + ", Direction: " + direction + ", Fuel Level: " + fuelLevel);
       System.out.println("Color: " + String.join(", ", color));
       System.out.println("Mesh File: " + meshFile);
       System.out.println("Texture File: " + textureFile);
       System.out.println("--------------------------------------------------");
   }
}


class VehicleFactory {
   private static final Map<String, VehicleModel> vehicleMap = new HashMap<>();

   public static VehicleModel getVehicle(String modelName, String manufacture, String[] color, String meshFile, String textureFile) {
       String key = modelName + "_" + manufacture;
       VehicleModel vehicle = vehicleMap.get(key);
       if (vehicle == null) {
           vehicle = new VehicleModel(modelName, manufacture, color, meshFile, textureFile);
           vehicleMap.put(key, vehicle);
           System.out.println("Creating a new vehicle: " + key);
       }
       return vehicle;
   }
}


public class TrafficSimulation {
   public static void main(String[] args) {

      String[] carcolors = {"Red", "Blue", "Green"};
      String[] buscolors = {"Red", "White", "Yellow"};

      Vehicle car1 = VehicleFactory.getVehicle("Toyota", "Sedan", carcolors, "sedan.obj", "sedan.png");
      Vehicle car2 = VehicleFactory.getVehicle("Toyota", "Sedan", carcolors, "sedan.obj", "sedan.png");
      Vehicle bus1 = VehicleFactory.getVehicle("Mercedes Bus", "Daimler Buses", buscolors, "bus.obj", "bus.png");
      Vehicle bus2 = VehicleFactory.getVehicle("Mercedes Bus", "Daimler Buses", buscolors, "bus.obj", "bus.png");
      

      car1.render(100, 200, 60.5, 90.0, 75.0);
      car2.render(150, 250, 70.0, 45.0, 80.0);
      bus1.render(200, 300, 50.0, 30.0, 65.0);
      bus2.render(250, 350, 55.0, 60.0, 70.0);
   }
}