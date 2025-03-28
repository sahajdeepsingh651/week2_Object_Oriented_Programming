// Abstract class Patient
abstract class Patient {
    private int patientId;
    private String name;
    private int age;

    // Constructor
    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // Getter and Setter methods (Encapsulation)
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Concrete method to display patient details
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    // Abstract method to calculate the patient's bill
    public abstract double calculateBill();
}

// Interface MedicalRecord
interface MedicalRecord {
    void addRecord(String record);
    String viewRecords();
}

// InPatient subclass (for patients admitted to the hospital)
class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyRate;
    private String medicalHistory;

    // Constructor
    public InPatient(int patientId, String name, int age, int daysAdmitted, double dailyRate) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyRate = dailyRate;
        this.medicalHistory = "";
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyRate;
    }

    @Override
    public void addRecord(String record) {
        medicalHistory += record + "\n";
    }

    @Override
    public String viewRecords() {
        return medicalHistory.isEmpty() ? "No records available" : medicalHistory;
    }
}

// OutPatient subclass (for patients visiting the hospital for consultations)
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private String medicalHistory;

    // Constructor
    public OutPatient(int patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.medicalHistory = "";
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        medicalHistory += record + "\n";
    }

    @Override
    public String viewRecords() {
        return medicalHistory.isEmpty() ? "No records available" : medicalHistory;
    }
}

// Main class to demonstrate the system
public class HospitalPatientManagementSystem {
    public static void main(String[] args) {
        // Create instances of patients
        Patient inPatient = new InPatient(1, "John Doe", 45, 5, 200); // 5 days stay, $200/day
        Patient outPatient = new OutPatient(2, "Jane Smith", 30, 100); // $100 consultation fee

        // Add medical records
        if (inPatient instanceof MedicalRecord) {
            MedicalRecord record = (MedicalRecord) inPatient;
            record.addRecord("Admitted for surgery");
            record.addRecord("Discharged after 5 days");
        }

        if (outPatient instanceof MedicalRecord) {
            MedicalRecord record = (MedicalRecord) outPatient;
            record.addRecord("Consulted for fever");
            record.addRecord("Prescribed antibiotics");
        }

        // Process patients and display their details and bill
        Patient[] patients = {inPatient, outPatient};

        for (Patient patient : patients) {
            System.out.println("\nPatient Details:");
            patient.getPatientDetails();
            System.out.println("Bill: " + patient.calculateBill());
            if (patient instanceof MedicalRecord) {
                MedicalRecord medicalRecord = (MedicalRecord) patient;
                System.out.println("Medical History:\n" + medicalRecord.viewRecords());
            }
        }
    }
}
