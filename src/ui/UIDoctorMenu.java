package ui;

import model.Doctor;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UIDoctorMenu {

    public static ArrayList<Doctor> doctorsAvailableAppointments = new ArrayList<>();
    public static void showDoctorMenu(){
        int response = 0;
        do{
            System.out.println("\n\n");
            System.out.println("Doctor");
            System.out.println("welcome "+ UIMenu.doctorLogged.getName());
            JOptionPane.showInputDialog(null, "1. add availale appoinment\n" +"2. my scheduled apponintments\n" +"0. logout ");
            //System.out.println("1. add availale appoinment");
            //System.out.println("2. my scheduled apponintments");
            //System.out.println("0. logout ");

            response = Integer.parseInt(JOptionPane.showInputDialog(null, "opcion: "));
            //Scanner sc = new Scanner(System.in);
            //response  = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    showAddAvailableAppointmentsMenu();
                    break;
                case 2:
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
            }

        }while (response != 0);
    }
    private static void showAddAvailableAppointmentsMenu(){
        int response = 0;
        do {
            System.out.println("------------");
            System.out.println("::Add Available Appointment");
            System.out.println(":: Select a month");

            for(int i = 0; i < 3; i++){
                int j = i +1;
                System.out.println(j +". "+ UIMenu.MONTHS[i]);
            }
            System.out.println("0. return");

            Scanner sc = new Scanner(System.in);
            response  = Integer.valueOf(sc.nextLine());

            if(response > 0 && response < 4){
                //1,2,3
                int monthSelectd = response;
                System.out.println(monthSelectd + " . "+ UIMenu.MONTHS[monthSelectd-1]);
                System.out.println("insert the date available: [dd/mm/yyyy]");
                String date= sc.nextLine();

                System.out.println("You date is: "+ date + "\n1. correcto \n2. change date");
                int responseDate = Integer.valueOf(sc.nextLine());
                if (responseDate == 2 ) continue;

                int responseTime = 0;
                String time = "";
                do {
                    System.out.println("insert the time available for date: "+ date + "[16:00]");
                    time = sc.nextLine();
                    System.out.println("you time is: "+ time +"\n1.correct \n2. change time");
                    responseTime = Integer.valueOf(sc.nextLine());

                }while (responseTime == 2);

                UIMenu.doctorLogged.addAvailableAppoinment(date, time);
                checkDoctorAvailableAppointments(UIMenu.doctorLogged);

            } else if(response == 0){
                showDoctorMenu();
            }

        }while (response !=0);
    }

    private static void checkDoctorAvailableAppointments(Doctor doctor){
        if(doctor.getAvailableAppointments().size() > 0 && !doctorsAvailableAppointments.contains(doctor)){
            doctorsAvailableAppointments.add(doctor);
        }
    }

}
