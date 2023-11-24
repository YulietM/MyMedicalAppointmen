package model;

public class Nurse extends User{
    private String speciality;
    public Nurse(String  name, String email){
        super(name, email);
    }

    @Override
    public void showDataUser() {
        System.out.println("Hostipal: Cruz Verde");
        System.out.println("Empleado del hospital: san rafael");
        System.out.println("Departamento: Nutriologia");
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
