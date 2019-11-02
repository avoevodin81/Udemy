package politechnica.polyclinic;

public class SocialPatientsCard implements PatientsCard{

    private static final String DEFAULT_ADDRESS = "";
    private String name;
    private String surname;
    private String address;
    private MedicalInsurancePolicy medicalInsurancePolicy;

    public SocialPatientsCard(String name, String surname, String address, MedicalInsurancePolicy medicalInsurancePolicy) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.medicalInsurancePolicy = medicalInsurancePolicy;
    }

    public SocialPatientsCard(String name, String surname, MedicalInsurancePolicy medicalInsurancePolicy) {
        this(name, surname, DEFAULT_ADDRESS, medicalInsurancePolicy);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public MedicalInsurancePolicy getMedicalInsurancePolicy() {
        return medicalInsurancePolicy;
    }

    public void setMedicalInsurancePolicy(MedicalInsurancePolicy medicalInsurancePolicy) {
        this.medicalInsurancePolicy = medicalInsurancePolicy;
    }

    @Override
    public String toString() {
        return "SocialPatientsCard{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", medicalInsurancePolicy=" + medicalInsurancePolicy +
                '}';
    }
}
