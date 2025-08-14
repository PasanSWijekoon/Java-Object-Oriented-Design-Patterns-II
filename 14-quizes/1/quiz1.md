### Urban Traffic Simulation System

You are working for a smart city simulation company that needs to build a real-time 3D urban traffic simulator for city planners. The simulator must display thousands of vehicles (cars, buses, trucks, motorcycles) moving along roads. Each vehicle has:

* **Intrinsic state** (shared, constant for many vehicles of the same type):
    * Model name
    * Manufacturer
    * Color options (preset list)
    * 3D geometry/mesh data (large file)
    * Texture file (large file)

* **Extrinsic state** (unique for each vehicle instance):
    * Current X, Y coordinates on the map
    * Speed
    * Direction
    * Current fuel level

The problem is that without optimization, the simulator becomes extremely slow because each vehicle stores its own copy of the large geometry and texture files, leading to excessive memory usage and rendering lag.

Your manager asks you to apply the suitable Design Pattern to optimize memory usage while still rendering thousands of moving vehicles.

Write down a simple code snippet to demonstrate the above given scenario.