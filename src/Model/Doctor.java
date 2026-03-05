package Model;

public class Doctor {
    private long ID;
    private String Name;
    private String specialty;
    private static int counter=0;
    private String phone;
    private double salary;

    public  Doctor( String Name, String specialty, String phone, double salary) {
        this.ID = ++counter;
        this.Name = Name;
        this.specialty = specialty;
        this.phone = phone;
        this.salary = salary;
    }

    public String getName() {
        return Name;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "Model.Doctor{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", specialty='" + specialty + '\'' +
                '}';
    }
}
