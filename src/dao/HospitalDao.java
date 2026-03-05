package dao;

import Model.Hospital;
import Model.exceptions.HospitalNotFound;

public interface HospitalDao {
    // CRUD
    // 1 - create
    void createHospital(Hospital hospital);
    // 2 - read
    Hospital[] getHospitals();
    // 3 - update
    void updateHospital(int ID, Hospital hospital);
    // 4 - delete
    void deleteHospital(int ID) throws HospitalNotFound;
    // 5 - read
    Hospital getOneHospital(int ID) throws HospitalNotFound;
}
