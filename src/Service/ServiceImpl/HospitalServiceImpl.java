package Service.ServiceImpl;

import Model.Hospital;
import Model.enums.City;
import Model.exceptions.HospitalNotFound;
import Service.HospitalService;
import dao.HospitalDao;
import dao.daoImple.HospitalDaoImpl;

public class HospitalServiceImpl implements HospitalService {
    private HospitalDaoImpl hospitalDaoImpl;

    public HospitalServiceImpl(HospitalDaoImpl hospitalDaoImpl) {
        this.hospitalDaoImpl = hospitalDaoImpl;
    }
    public HospitalDaoImpl getHospitalDaoImpl() {
        return hospitalDaoImpl;
    }
    public void setHospitalDaoImpl(HospitalDaoImpl hospitalDaoImpl) {
        this.hospitalDaoImpl = hospitalDaoImpl;
    }
    @Override
    public void createHospital(Hospital hospital) throws  HospitalNotFound {
        if (hospital == null) {
            throw new HospitalNotFound("House is null");
        }
        if (hospital.getCapacity() == 0) {
            throw new HospitalNotFound("capacity is null");
        }
        if (hospital.getId() == 0) {
            throw new HospitalNotFound("ID is null");
        }
        if (hospital.getCity() == null) {
            throw new HospitalNotFound("type is null");
        }
        if (hospital.getHospitalName() == null || hospital.getHospitalName().isEmpty()) {
            throw new HospitalNotFound("name is null");
        }
        if (hospital.getHospitalAddress() == null || hospital.getHospitalAddress().isEmpty()) {
            throw new HospitalNotFound("address is null");
        }

        hospitalDaoImpl.createHospital(hospital);
        System.out.println("Hospital created successfully");
    }

    @Override
    public Hospital[] getHospitals() {
        return hospitalDaoImpl.getHospitals();
    }

    @Override
    public void updateHospital(int ID, Hospital hospital) throws HospitalNotFound {

        if (hospital == null) {
            throw new HospitalNotFound("Hospital is null");
        }

        hospitalDaoImpl.updateHospital(ID, hospital); // исправлено
    }

    @Override
    public void deleteHospital(int ID) throws HospitalNotFound {
        if (ID == 0) {
            throw new HospitalNotFound("ID is null");
        }
        hospitalDaoImpl.deleteHospital(ID);
        System.out.println("Hospital deleted successfully");
    }

    @Override
    public Hospital getOneHospital(int ID) throws HospitalNotFound {
        if (ID == 0) {
            throw new HospitalNotFound("ID is null");
        }
        return hospitalDaoImpl.getOneHospital(ID);
    }

    @Override
    public Hospital getHospitalByCity(City city) {
        for (Hospital hospital : getHospitals()) {
            if (hospital.getCity().equals(city)) {
                return hospital;
            }
        }
        return null;
    }
}
