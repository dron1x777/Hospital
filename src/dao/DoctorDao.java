package dao;

import Model.Doctor;
import Model.exceptions.HospitalNotFound;

public interface DoctorDao {
    //CRUD
    // 1 - create
    void createDoctor(Doctor doctor, long hospitalID) throws HospitalNotFound;
    // 2 - read
    Doctor[] getDoctorsByHospital(int hospitalID);

    // 3 - update
    void updateDoctor(Doctor doctor, long doctorID, long hospitalID);
    // 4 - delete
    void deleteDoctor(int doctorID, long hospitalID);
    // 5 - read
    Doctor getDoctorById(int doctorID);

}
