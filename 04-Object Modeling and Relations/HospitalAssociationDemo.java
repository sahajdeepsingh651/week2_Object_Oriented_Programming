import java.util.*;

class Patient {
    String name;
    List<Doctor> consultedDoctors;

    public Patient(String name) {
        this.name = name;
        consultedDoctors = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        if (!consultedDoctors.contains(doctor)) {
            consultedDoctors.add(doctor);
        }
    }

    public void showConsultedDoctors() {
        System.out.println("Patient: " + name + " has consulted:");
        for (Doctor d : consultedDoctors) {
            System.out.println(" - Dr. " + d.name);
        }
    }
}

class Doctor {
    String name;
    List<Patient> patientsSeen;

    public Doctor(String name) {
        this.name = name;
        patientsSeen = new ArrayList<>();
    }

    public void consult(Patient patient) {
        System.out.println("Dr. " + name + " is consulting " + patient.name);
        if (!patientsSeen.contains(patient)) {
            patientsSeen.add(patient);
        }
        patient.addDoctor(this); // maintain bidirectional link
    }

    public void showPatients() {
        System.out.println("Dr. " + name + " has seen:");
        for (Patient p : patientsSeen) {
            System.out.println(" - " + p.name);
        }
    }
}

class Hospital {
    String hospitalName;
    List<Doctor> doctors;
    List<Patient> patients;

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        doctors = new ArrayList<>();
        patients = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void showHospitalInfo() {
        System.out.println("Hospital: " + hospitalName);
        System.out.println("Doctors:");
        for (Doctor d : doctors) {
            System.out.println(" - Dr. " + d.name);
        }
        System.out.println("Patients:");
        for (Patient p : patients) {
            System.out.println(" - " + p.name);
        }
    }
}

class HospitalAssociationDemo {
    public static void main(String[] args) {
        Hospital cityCare = new Hospital("CityCare Hospital");

        Doctor drRavi = new Doctor("Ravi");
        Doctor drMaya = new Doctor("Maya");

        Patient amit = new Patient("Amit");
        Patient neha = new Patient("Neha");

        cityCare.addDoctor(drRavi);
        cityCare.addDoctor(drMaya);

        cityCare.addPatient(amit);
        cityCare.addPatient(neha);

        drRavi.consult(amit);
        drRavi.consult(neha);
        drMaya.consult(amit);

        System.out.println();
        drRavi.showPatients();
        drMaya.showPatients();

        System.out.println();
        amit.showConsultedDoctors();
        neha.showConsultedDoctors();

        System.out.println();
        cityCare.showHospitalInfo();
    }
}
