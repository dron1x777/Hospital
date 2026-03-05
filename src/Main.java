import DataBase.DataBase;
import Model.Hospital;
import Model.enums.City;
import Model.exceptions.HospitalNotFound;
import Service.HospitalService;
import Service.ServiceImpl.HospitalServiceImpl;
import dao.daoImple.HospitalDaoImpl;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DataBase dataBase = new DataBase(new Hospital[]{});
        HospitalDaoImpl hospitalDao = new HospitalDaoImpl(dataBase);
        HospitalService hospitalService = new HospitalServiceImpl(hospitalDao);
        while (true) {
            menu();
            System.out.println("Enter your choice:");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("Enter hospital name:");
                    String hospitalName = sc.next();
                    System.out.println("Enter hospital address:");
                    String hospitalAddress = sc.next();
                    System.out.println("Enter hospital city:");
                    String hospitalCity = sc.next().toUpperCase();
                    City city = City.valueOf(hospitalCity);
                    System.out.println("Enter hospital capacity:");
                    int capacity = sc.nextInt();
                    Hospital hospital = new Hospital(hospitalName, hospitalAddress, city, capacity, 0
                    );
                    try {
                        hospitalService.createHospital(hospital);
                    } catch (HospitalNotFound e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 2 -> {
                    Hospital[] hospitals = hospitalService.getHospitals();
                    System.out.println(Arrays.toString(hospitals));
                }
                case 3 -> {
                    System.out.println("Enter city:");
                    String hospitalCity = sc.next().toUpperCase();
                    City city = City.valueOf(hospitalCity);
                    Hospital hospital = hospitalService.getHospitalByCity(city);
                    if (hospital != null) {
                        System.out.println(hospital);
                    } else {System.out.println("Hospital not found");
                    }
                }
                case 4 -> {
                    System.out.println("Enter hospital id:");
                    int id = sc.nextInt();
                    try {
                        System.out.println(hospitalService.getOneHospital(id));
                    } catch (HospitalNotFound e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 5 -> {
                    System.out.println("Enter hospital id to delete:");
                    int id = sc.nextInt();
                    try {
                        hospitalService.deleteHospital(id);
                    } catch (HospitalNotFound e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 6-> {
                    System.out.println("Enter hospital id to update:");
                    int id = sc.nextInt();
                    System.out.println("Enter new name:");
                    String name = sc.next();
                    System.out.println("Enter new address:");
                    String address = sc.next();
                    System.out.println("Enter new city:");
                    String cityStr = sc.next().toUpperCase();
                    City city = City.valueOf(cityStr);
                    System.out.println("Enter new capacity:");
                    int capacity = sc.nextInt();
                    Hospital hospital = new Hospital(name, address, city, capacity, 0
                    );
                    try {
                        hospitalService.updateHospital(id, hospital);
                    } catch (HospitalNotFound e) {
                        System.out.println(e.getMessage());
                    }
                }
                default -> System.out.println("Wrong choice");
            }
        }
    }
    static void menu() {
        System.out.println("""
                
                1. Create hospital
                2. Get all hospitals
                3. Get hospital by city
                4. Get hospital by id
                5. Delete hospital by id
                6. Update hospital by id
                
                """);
    }
}