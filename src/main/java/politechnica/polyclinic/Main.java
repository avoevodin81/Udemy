package politechnica.polyclinic;

import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        //create polyclinic
        Polyclinic polyclinic = new Polyclinic(1, "Deribasovskaya");

        //create patients cards with insurance policy
        MedicalInsurancePolicy medicalInsurancePolicy1 = new ObligatoryMedicalInsurancePolicy();
        SocialPatientsCard patientsCard1 = new SocialPatientsCard("Ivan", "Ivanov", "Reishelevskaya", medicalInsurancePolicy1);

        MedicalInsurancePolicy medicalInsurancePolicy2 = new VoluntaryMedicalInsurancePolicy();
        SocialPatientsCard patientsCard2 = new SocialPatientsCard("Petr", "Petrov", "Arnautskaya", medicalInsurancePolicy2);

        MedicalInsurancePolicy medicalInsurancePolicy3 = new ObligatoryMedicalInsurancePolicy();
        PaidPatientsCard patientsCard3 = new PaidPatientsCard("John", "Connor", "Reishelevskaya", medicalInsurancePolicy3);

        MedicalInsurancePolicy medicalInsurancePolicy4 = new VoluntaryMedicalInsurancePolicy(100);
        PaidPatientsCard patientsCard4 = new PaidPatientsCard("John", "Connor", "Reishelevskaya", medicalInsurancePolicy4);
        Bill bill1 = new Bill();
        Date date = new Date();
        date.setDate(25);
        date.setMonth(1);
        date.setYear(2019);
        bill1.setDate(date);
        bill1.setSum(100);
        patientsCard4.addBill(bill1);

        Bill bill2 = new Bill();
        Date date2 = new Date();
        date2.setDate(25);
        date2.setMonth(1);
        date2.setYear(2019);
        bill2.setDate(date);
        bill2.setSum(200);
        patientsCard4.addBill(bill2);

        //add patients card into polyclinic
        polyclinic.addPatientsCard(patientsCard1);
        polyclinic.addPatientsCard(patientsCard2);
        polyclinic.addPatientsCard(patientsCard3);
        polyclinic.addPatientsCard(patientsCard4);

        System.out.println(polyclinic.totalBilledAmount(date));
    }

    private static void printPatientsCard(SocialPatientsCard socialPatientsCard) {
        System.out.println("- Name: " + socialPatientsCard.getName());
        System.out.println("- Surname: " + socialPatientsCard.getSurname());
        System.out.println("- Address: " + socialPatientsCard.getAddress());
//        System.out.println("- Policy Number: " + socialPatientsCard.getPolicyNumber());
    }

    private static void printPolyclinic(Polyclinic polyclinic) {
        System.out.println("Номер поликлиники: " + polyclinic.getNumber());
        System.out.println("Адрес поликлиники: " + polyclinic.getAddress());
//        printPatientCards(polyclinic.getSocialPatientsCards());
    }

    private static void printPatientCards(SocialPatientsCard socialPatientsCard) {
        printPatientsCard(socialPatientsCard);
        System.out.println();
    }

    private static void printPatientCards(SocialPatientsCard[] socialPatientsCards) {
        AtomicInteger integer = new AtomicInteger(1);
        Arrays.asList(socialPatientsCards)
                .forEach(socialPatientsCard -> {
                    System.out.println("PtientsCard: " + integer.getAndIncrement());
                    printPatientCards(socialPatientsCard);
                });
    }


    public void testData() {

    }


}
