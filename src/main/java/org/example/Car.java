package org.example;

public class Car {
    private int id;
    private String model;
    private int implementationYear;

    public Car(int id, String model, int implementationYear) {
        this.id = id;
        this.model = model;
        this.implementationYear = implementationYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getImplementationYear() {
        return implementationYear;
    }

    public void setImplementationYear(int implementationYear) {
        this.implementationYear = implementationYear;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", implementationYear=" + implementationYear +
                '}';
    }
}
