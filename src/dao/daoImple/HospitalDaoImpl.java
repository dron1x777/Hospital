package dao.daoImple;

import DataBase.DataBase;
import Model.Hospital;
import Model.exceptions.HospitalNotFound;
import dao.HospitalDao;

import java.util.Arrays;

public class HospitalDaoImpl implements HospitalDao {
    private DataBase dataBase;

    public HospitalDaoImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }


    @Override
    public void createHospital(Hospital hospital) {
        Hospital[] hospitals = Arrays.copyOf(dataBase.getHospitals(), dataBase.getHospitals().length+1);
        hospitals[hospitals.length-1] = hospital;
        dataBase.setHospitals(hospitals);
    }

    @Override
    public Hospital[] getHospitals() {
        return dataBase.getHospitals();
    }

    @Override
    public void updateHospital(int ID, Hospital hospital) {
        for (int i = 0; i < dataBase.getHospitals().length; i++) {
            if (dataBase.getHospitals()[i].getId() == ID) {
                Hospital hospital1 = dataBase.getHospitals()[i];
                if(hospital1.getHospitalAddress() != null && !hospital1.getHospitalAddress().equals(hospital.getHospitalAddress())) {
                    hospital1.setHospitalAddress(hospital.getHospitalAddress());
                }
                if(hospital1.getHospitalName() != null && !hospital1.getHospitalName().equals(hospital.getHospitalName())) {
                    hospital1.setHospitalName(hospital.getHospitalName());
                }
                if(hospital1.getCapacity() != hospital.getCapacity()) {
                    hospital1.setCapacity(hospital.getCapacity());
                }
                if(hospital1.getCity() != null && !hospital1.getCity().equals(hospital.getCity())) {
                    hospital1.setCity(hospital.getCity());
                }
                dataBase.getHospitals()[i] = hospital1;
            }
        }
    }

    @Override
    public void deleteHospital(int ID) throws HospitalNotFound {
        Hospital[] hospitals = new Hospital[dataBase.getHospitals().length - 1];
        int counter = 0;
        boolean exists = false;

        for (int i = 0; i < dataBase.getHospitals().length; i++) {
            if (dataBase.getHospitals()[i].getId() == ID) {
                exists = true;
            }
        }

        if (exists) {
            for (int i = 0; i < dataBase.getHospitals().length; i++) {

                if (dataBase.getHospitals()[i].getId() != ID) { // исправлено
                    hospitals[counter++] = dataBase.getHospitals()[i];
                }

            }
            dataBase.setHospitals(hospitals);
        } else {
            throw new HospitalNotFound("Hospital not found");
        }
    }

    @Override
    public Hospital getOneHospital(int ID) throws HospitalNotFound {
        for (int i = 0; i < dataBase.getHospitals().length; i++) {
            if (dataBase.getHospitals()[i].getId() == ID) {
                return dataBase.getHospitals()[i];
            }
        }
        throw new HospitalNotFound("Hospital with "+ID+" id not found!!!");
    }
}
