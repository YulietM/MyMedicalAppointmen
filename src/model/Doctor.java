package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

    public class Doctor extends User {
    //atributos
    private String speciality;

    //metodos (comportamientos
    public Doctor(String name, String email){
        super(name, email);
    }
    public String getSpeciality() {
        return speciality;
    }
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
    // este se dedida a crear e ingrementar la lista
    ArrayList<AvailableAppointment>availableAppointments= new ArrayList<>(); //coleccion de objetos
    public void addAvailableAppoinment(String date, String time){
        availableAppointments.add(new AvailableAppointment(date, time));
    }
    //devuelve la lista completa de citas
    public ArrayList<AvailableAppointment>getAvailableAppointments(){
        return availableAppointments;
    }
    @Override
    public String toString() {
        return super.toString()+ "\nSpeciality "+ speciality + "\nAvailable "+ availableAppointments.toString();
    }
    @Override
    public void showDataUser() {
        System.out.println("Empleado del hospital: gonzales valencia");
        System.out.println("Hospita: Cruz Roja");
        System.out.println("Departamento: Cancerologia");
        System.out.println("DEpartamentos: Pediatria");
    }
        //clase anidada
    public static class AvailableAppointment {
        private int id;
        private Date date;
        private String time;
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");

        public AvailableAppointment(String date, String time){
            try {
                this.date = format.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            this.time = time;
        }
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Date getDate() {
            return date;
        }

        //sobre cargar de metodos
        public String getDate(String Date){
            return format.format(date);
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "Available Appointments \n Date: "+  date+ "\nTime: "+ time;
        }
    }


}

/*
Los enumerations son tipos de datos muy especiales pues este, es el único en su tipo que sirve para declarar
una colección de constantes, al ser así estaremos obligados a escribirlos con mayúsculas.
Usaremos enum cada vez que necesitemos representar un conjunto fijo de constantes. Por ejemplo los días de la semana.

Así podemos declarar un enumeration usando la palabra reservada enum.

   public enum Day {
	SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
	THURSDAY, FRIDAY, SATURDAY
}

Puedo crear referencias de enumerations de la siguiente forma:

Day day;
switch (day) {
	case MONDAY:
		System.out.println(“Mondays are good.”);
		break;
	case FRIDAY:
		System.out.println(“Fridays are nice”);
		break;
	case SATURDAY: case: SUNDAY:
		System.out.println(“Weekends are the best”);
		break;
	default:
		System.out.println(“Midweek are so-so”);
		break;

}
Y puedo llamar un valor del enumeration así:
Day.MONDAY;
Day.FRIDAY;
Day.SATURDAY

Los enumerations pueden tener atributos, métodos y constructores, como se muestra:

public enum Day {
  MONDAY("Lunes");
  TUESDAY("Jueves");
  FRIDAY("Viernes");
  SATURDAY("Sábado");
  SUNDAY("Domingo");

  private String spanish;
  private Day(String s) {
    spanish = s;
  }

  private String getSpanish() {
    return spanish;
  }
}

Y para utilizarlo lo podemos hacer así:

System.out.println(Day.MONDAY);
Imprimirá: MONDAY

System.out.println(Day.MONDAY.getSpanish());
Imprimirá: Lunes
 */
