package Service;

import Model.Hospital;
import Model.enums.City;
import Model.exceptions.HospitalNotFound;

public interface HospitalService {
    // CRUD
    // 1 - create
    void createHospital(Hospital hospital) throws HospitalNotFound;
    // 2 - read
    Hospital[] getHospitals();
    // 3 - update
    void updateHospital(int ID, Hospital hospital) throws  HospitalNotFound;
    // 4 - delete
    void deleteHospital(int ID) throws HospitalNotFound;
    // 5 - read
    Hospital getOneHospital(int ID) throws HospitalNotFound;
    // 6 - read
    Hospital getHospitalByCity(City city);
}
