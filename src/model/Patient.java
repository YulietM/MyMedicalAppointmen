package model;

public class Patient extends User {
    public int id;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;
    private String birthday;
    private double weight;
    private double height;
    private String blood;

    public Patient(String name, String email){
        super(name, email);
    }
    public void setPhoneNumber(String phoneNumber) {

    }
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getWeight() {
        return this.weight + " Kg.";
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return this.height + " Mts";
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return super.toString() + "\nAge: "+ birthday + "\n Weight: "+ getWeight() +
                "\n Height "+getHeight()+ "\nBlood "+ blood;
    }
    @Override
    public void showDataUser() {
        System.out.println("paciente");
        System.out.println("historia clinica");

    }
}
