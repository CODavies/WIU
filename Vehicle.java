 public class Vehicle {

    String typeOfVehicle = "Four wheelers";

    class Car {

        String color = "Blue";
        String bodyStyle = "Sedan";

        void displayCarDetails() {
            System.out.println("Type of Vehicle: " + typeOfVehicle);
            System.out.println("Color of Car: " + color);
            System.out.println("Body Style of Car: " + bodyStyle);
        }
    }

    public static void main(String[] args) {

        Vehicle vehicle = new Vehicle();
        Vehicle.Car car = vehicle.new Car();

        car.displayCarDetails();
    }
}