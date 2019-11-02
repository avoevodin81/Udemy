package politechnica.polyclinic;

public interface PatientsCard {
    String getName();
    void setName(String name);
    String getSurname();
    void setSurname(String surname);
    String getAddress();
    void setAddress(String address);
    MedicalInsurancePolicy getMedicalInsurancePolicy();
    void setMedicalInsurancePolicy(MedicalInsurancePolicy medicalInsurancePolicy);
}
