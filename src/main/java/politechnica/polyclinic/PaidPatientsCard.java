package politechnica.polyclinic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PaidPatientsCard implements PatientsCard {

    private static final String DEFAULT_ADDRESS = "";
    private String name;
    private String surname;
    private String address;
    private MedicalInsurancePolicy medicalInsurancePolicy;
    private List<Bill> bills;

    public PaidPatientsCard() {
        bills = new ArrayList<>();
    }

    public PaidPatientsCard(String name, String surname) {
        this(name, surname, DEFAULT_ADDRESS, null, new ArrayList<>());
    }

    public PaidPatientsCard(String name, String surname, String address) {
        this(name, surname, address, null, new ArrayList<>());
    }

    public PaidPatientsCard(String name, String surname, String address,
                            MedicalInsurancePolicy medicalInsurancePolicy) {
        this(name, surname, address, medicalInsurancePolicy, new ArrayList<>());
    }

    public PaidPatientsCard(String name, String surname, String address,
                            MedicalInsurancePolicy medicalInsurancePolicy, List<Bill> bills) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.medicalInsurancePolicy = medicalInsurancePolicy;
        this.bills = bills;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public MedicalInsurancePolicy getMedicalInsurancePolicy() {
        return medicalInsurancePolicy;
    }

    @Override
    public void setMedicalInsurancePolicy(MedicalInsurancePolicy medicalInsurancePolicy) {
        this.medicalInsurancePolicy = medicalInsurancePolicy;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    public int totalBilledAmount() {
        return bills.stream()
                .mapToInt(Bill::getSum)
                .sum();
    }

    public List<Bill> billedAmount(Date date) {
        return bills.stream()
                .filter(bill -> bill.getDate().equals(date))
                .collect(Collectors.toList());
    }

    public void addBill(Bill bill) {
        bills.add(bill);
    }

    public void removeBill(Date date, int billAmount) {
        bills.removeIf(bill -> bill.getDate().equals(date) && bill.getSum() == billAmount);
    }

    @Override
    public String toString() {
        return "PaidPatientsCard{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", medicalInsurancePolicy=" + medicalInsurancePolicy +
                ", bills=" + bills +
                '}';
    }
}
