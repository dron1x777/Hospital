package Model;

import Model.enums.City;
import java.util.Arrays;

public class Hospital {
    private String hospitalName;
    private String hospitalAddress;
    private int id;
    private City city;
    private int capacity;
    private Doctor[] doctor = new Doctor[]{}; // исправлено
    private int doctorSize = 0;
    private static int counter = 0;

    public Hospital(String hospitalName, String hospitalAddress, City city, int capacity, int doctorSize) {
        this.hospitalName = hospitalName;
        this.hospitalAddress = hospitalAddress;
        this.city = city;
        this.capacity = capacity;
        this.doctorSize = doctorSize;
        this.id = ++counter;
    }

    public Doctor[] getDoctors() {
        return doctor;
    }

    public void setDoctors(Doctor[] doctor) {
        this.doctor = doctor;
    }

    public int getId() {
        return id;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public String getHospitalAddress() {
        return hospitalAddress;
    }

    public City getCity() {
        return city;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public void setHospitalAddress(String hospitalAddress) {
        this.hospitalAddress = hospitalAddress;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "capacity=" + capacity +
                ", hospitalName='" + hospitalName + '\'' +
                ", hospitalAddress='" + hospitalAddress + '\'' +
                ", id=" + id +
                ", city=" + city +
                ", doctor=" + Arrays.toString(doctor) +
                '}';
    }
}