package org.example;

public class Main {
    public static void main(String[] args) {
        CarDAO carDAO = new CarDAO();
        Car car1 = new Car(1, "BMW X5", 2010);
        Car car2 = new Car(2, "Toyota Supra", 2014);
        Car car3 = new Car(3, "Mitsubishi Lancer X", 2009);
        Car car4 = new Car(4, "Mazda RX8", 2005);

        carDAO.insert(car1);
        carDAO.insert(car2);
        carDAO.insert(car3);
        carDAO.insert(car4);
        System.out.println();
        carDAO.findAll();
        System.out.println();
        System.out.println(carDAO.findById(2));
        carDAO.update(2, "Toyota Avensys", 2008);
        carDAO.findAll();
        System.out.println();
        carDAO.deleteById(1);
    }
}