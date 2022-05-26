package mongoDB;
import ClassesMain.Patient;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class App {
    public static Scanner scanner = new Scanner(System.in);

    public static <T> T validateInput(String message,Class<?> type) {
        scanner = new Scanner(System.in);
        System.out.print(message + " ");
        try {
            if(type == String.class) {
                return (T) scanner.nextLine();
            }
            if(type == int.class) {
                return (T) Integer.valueOf(scanner.nextLine());
            }
            if(type == boolean.class) {
                return (T) Boolean.valueOf(scanner.nextLine());
            }
            if(type == Date.class) {
                return (T) new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(scanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Can not perform the operation");
            return validateInput(message,type);
        }
        return null;

    }



    public static void addPatient() {
        boolean isHealthy = false;
        String name = validateInput("Enter patient's name :",String.class);
        while(!Objects.requireNonNull(name).matches("[a-zA-Z]+")) {
            System.out.println("Invalid input");
            name = validateInput("Enter patient's name :",String.class);
        }
        int age = validateInput("Enter patient's age :",int.class);
        while(age <=10 || age >= 100) {
            System.out.println("Invalid input");
            age = validateInput("Enter patient's age :",int.class);
        }
        String check = validateInput("Enter patient's health state(healthy/sick):",String.class);
        if(Objects.requireNonNull(check).equalsIgnoreCase("Healthy")) {
            isHealthy = true;
        } else if(check.equalsIgnoreCase("Sick")) {
            isHealthy = false;
        } else {
            while(!Objects.requireNonNull(check).equalsIgnoreCase("Healthy") && !check.equalsIgnoreCase("Sick")) {
                System.out.println("Invalid input");
                check = validateInput("Enter patient's health state(healthy/sick):",String.class);
            }
        }
        String reservationId = validateInput("Enter patient's reservation id:",String.class);
        while(!Objects.requireNonNull(reservationId).matches("\\d+") || reservationId.length() != 3) {
            System.out.println("Invalid input");
            reservationId = validateInput("Enter patient's reservation id:",String.class);
        }
        String doctorName = validateInput("Enter patient's doctor name:",String.class);
        while(!Objects.requireNonNull(doctorName).matches("[a-zA-Z\\d.]+")) {
            System.out.println("Invalid input");
            doctorName = validateInput("Enter patient's doctor name:",String.class);
        }
        String doctorSpecialization = validateInput("Enter patient's doctor specialization:",String.class);
        while(!Objects.requireNonNull(doctorSpecialization).matches("[a-zA-Z\\d\\s]+")) {
            System.out.println("Invalid input");
            doctorSpecialization = validateInput("Enter patient's doctor specialization:",String.class);
        }
        String deceaseName = validateInput("Enter patient's decease name:",String.class);
        while(!Objects.requireNonNull(deceaseName).matches("[a-zA-Z\\d\\s]+")) {
            System.out.println("Invalid input");
            deceaseName = validateInput("Enter patient's decease name:",String.class);
        }

        Date timeOfVisit = validateInput("Enter patient's time of visit in yyyy-MM-dd HH:mm format:",Date.class);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date parseDate;
        try {
            parseDate = sdf.parse(sdf.format(timeOfVisit));
        } catch (ParseException e) {
            System.out.println("Invalid input");
            return;
        }
        while(Objects.requireNonNull(timeOfVisit).before(new Date())) {
            System.out.println("Can't choose a date which has already passed!");
            timeOfVisit = validateInput("Enter patient's time of visit:",Date.class);
        }
        Patient patient = new Patient(name, age, isHealthy, reservationId, doctorName, doctorSpecialization, deceaseName, parseDate);
        DBUtils.getInstance().addPatient(patient);
        DBUtils.getInstance().findPatientByName(name);
    }

    public static void menu() {
        System.out.println("1.Add several patients");
        System.out.println("2.Add one patient");
        System.out.println("3.Delete all patients");
        System.out.println("4.Delete one patient");
        System.out.println("5.Update a patient's health state");
        System.out.println("6.Change a patient's hour of visit");
        System.out.println("7.Find a patient by a given name");
        System.out.println("8.Print all patients");
        System.out.println("9.Exit");
    }


    public static void app() {
        System.out.println("Hospital database!");
        menu();
        System.out.print("Enter your choice: ");
        String choice = scanner.nextLine();
        boolean exit = false;
        do {
            switch (choice) {
                case "1" -> {
                    int numberOfPatients = validateInput("How many patients do you want to add(Minimum 2)?", int.class);
                    while (numberOfPatients < 2) {
                        System.out.println("Invalid input");
                        numberOfPatients = validateInput("How many patients do you want to add?", int.class);
                    }
                    for (int i = 0; i < numberOfPatients; i++) {
                        addPatient();
                    }
                    System.out.println("------------------------------------------------------");
                    System.out.println();
                    menu();
                    choice = scanner.nextLine();
                }
                case "2" -> {
                    addPatient();
                    menu();
                    choice = scanner.nextLine();
                }
                case "3" -> {
                    DBUtils.getInstance().deleteAllPatients();
                    System.out.println("------------------------------------------------------");
                    System.out.println();
                    menu();
                    choice = scanner.nextLine();
                }
                case "4" -> {
                    String name = validateInput("Enter patient's name :", String.class);
                    while (!Objects.requireNonNull(name).matches("[a-zA-Z]+")) {
                        System.out.println("Invalid input");
                        name = validateInput("Enter patient's name :", String.class);
                    }
                    DBUtils.getInstance().deletePatient(name);
                    System.out.println(name + " has been deleted");
                    System.out.println("------------------------------------------------------");
                    System.out.println();
                    menu();
                    choice = scanner.nextLine();
                }
                case "5" -> {
                    String name = validateInput("Enter patient's name :", String.class);
                    while (!Objects.requireNonNull(name).matches("[a-zA-Z]+")) {
                        System.out.println("Invalid input");
                        name = validateInput("Enter patient's name :", String.class);
                    }
                    System.out.println(name + " is now not " + DBUtils.getInstance().getPatientHealthState(name));
                    DBUtils.getInstance().updatePatientHealthState(name);
                    System.out.println("------------------------------------------------------");
                    System.out.println();
                    menu();
                    choice = scanner.nextLine();
                    System.out.println();
                }
                case "6" -> {
                    String name = validateInput("Enter patient's name :", String.class);
                    while (!Objects.requireNonNull(name).matches("[a-zA-Z]+")) {
                        System.out.println("Invalid input");
                        name = validateInput("Enter patient's name :", String.class);
                    }
                    Date timeOfVisit = validateInput("Enter patient's time of visit in yyyy-MM-dd HH:mm format.", Date.class);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    Date parseDate;
                    try {
                        parseDate = sdf.parse(sdf.format(timeOfVisit));
                    } catch (ParseException e) {
                        System.out.println("Invalid input");
                        return;
                    }
                    while (Objects.requireNonNull(timeOfVisit).before(new Date())) {
                        System.out.println("Can't choose a date which has already passed!");
                        timeOfVisit = validateInput("Enter patient's time of visit:", Date.class);
                    }
                    if (DBUtils.getInstance().getPatientHourOfVisit(name) != null) {
                        DBUtils.getInstance().updatePatientHourOfVisit(name, parseDate);
                        System.out.println(name + "'s time of visit is now " + DBUtils.getInstance().getPatientHourOfVisit(name));
                        System.out.println("------------------------------------------------------");
                        System.out.println();
                        menu();
                        choice = scanner.nextLine();
                    } else {
                        System.out.println("Patient with this name doesn't exist!");
                    }
                }
                case "7" -> {
                    String name = validateInput("Enter patient's name :", String.class);
                    while (!Objects.requireNonNull(name).matches("[a-zA-Z]+")) {
                        System.out.println("Invalid input");
                        name = validateInput("Enter patient's name :", String.class);
                    }
                    DBUtils.getInstance().findPatientByName(name);
                }
                case "8" -> {
                    DBUtils.getInstance().printAllPatients();
                    System.out.println("------------------------------------------------------");
                    System.out.println();
                    menu();
                    choice = scanner.nextLine();
                }
                case "9" -> exit = true;
            }

        } while (!exit);
    }
}
