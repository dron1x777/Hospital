package DataBase;

import Model.Doctor;
import Model.Hospital;

public class DataBase {
    private Hospital[] hospitals;
    private int size = 0;

    public DataBase(Hospital[] hospitals) {
        this.hospitals = hospitals;
        this.size = hospitals.length;
    }

    public Hospital[] getHospitals() {
        return hospitals;
    }

    public void setHospitals(Hospital[] hospitals) {
        this.hospitals = hospitals;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
