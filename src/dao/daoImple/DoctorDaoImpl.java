package dao.daoImple;

import DataBase.DataBase;
import Model.Doctor;
import Model.Hospital;
import Model.exceptions.HospitalNotFound;
import dao.DoctorDao;

import java.util.Arrays;

public class DoctorDaoImpl implements DoctorDao {

    private DataBase dataBase;

    public DoctorDaoImpl(DataBase dataBase) { // исправление
        this.dataBase = dataBase;
    }

    @Override
    public void createDoctor(Doctor doctor, long hospitalID) throws HospitalNotFound {

        Hospital hospital = null;

        for (int i = 0; i < dataBase.getHospitals().length; i++) {

            if (dataBase.getHospitals()[i].getId() == hospitalID) {
                hospital = dataBase.getHospitals()[i];
            }

        }

        if (hospital == null) {
            throw new HospitalNotFound("Hospital not found");
        }

        Doctor[] doctors = Arrays.copyOf(hospital.getDoctors(), hospital.getDoctors().length + 1);

        doctors[doctors.length - 1] = doctor;

        hospital.setDoctors(doctors);
    }

    @Override
    public Doctor[] getDoctorsByHospital(int hospitalID) {

        for (int i = 0; i < dataBase.getHospitals().length; i++) {

            if (dataBase.getHospitals()[i].getId() == hospitalID) {
                return dataBase.getHospitals()[i].getDoctors();
            }

        }

        return null;
    }

    @Override
    public void updateDoctor(Doctor doctor, long doctorID, long hospitalID) {

        for (int i = 0; i < dataBase.getHospitals().length; i++) {

            if (dataBase.getHospitals()[i].getId() == hospitalID) {

                for (int j = 0; j < dataBase.getHospitals()[i].getDoctors().length; j++) {

                    if (dataBase.getHospitals()[i].getDoctors()[j].getID() == doctorID) {

                        dataBase.getHospitals()[i].getDoctors()[j] = doctor;
                        System.out.println("Doctor updated");
                        return;

                    }

                }

            }

        }

        System.out.println("something went wrong");

    }

    @Override
    public void deleteDoctor(int doctorID, long hospitalID) {

        for (int i = 0; i < dataBase.getHospitals().length; i++) {

            if (dataBase.getHospitals()[i].getId() == hospitalID) {

                Doctor[] doctors = dataBase.getHospitals()[i].getDoctors();

                Doctor[] newDoctors = new Doctor[doctors.length - 1];

                int counter = 0;

                for (int j = 0; j < doctors.length; j++) {

                    if (doctors[j].getID() != doctorID) {

                        newDoctors[counter++] = doctors[j];

                    }

                }

                dataBase.getHospitals()[i].setDoctors(newDoctors);

            }

        }

    }

    @Override
    public Doctor getDoctorById(int doctorID) {

        for (int i = 0; i < dataBase.getHospitals().length; i++) {

            for (int j = 0; j < dataBase.getHospitals()[i].getDoctors().length; j++) {

                if (dataBase.getHospitals()[i].getDoctors()[j].getID() == doctorID) {

                    return dataBase.getHospitals()[i].getDoctors()[j];

                }

            }

        }

        return null;
    }
}