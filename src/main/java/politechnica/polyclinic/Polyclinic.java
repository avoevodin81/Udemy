package politechnica.polyclinic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class Polyclinic {

    private int number;
    private String address;
    private PatientsCard[] patientsCards;

    public Polyclinic(int number, String address, PatientsCard... patientsCards) {
        this.number = number;
        this.address = address;
        this.patientsCards = patientsCards;
    }

    public Polyclinic(int number, String address) {
        this(number, address, new PatientsCard[0]);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPatientsQuantity() {
        return patientsCards.length;
    }

    public PatientsCard getPatientCard(int policyNumber) {
        return Arrays.stream(patientsCards)
                .filter(patientsCards ->
                        patientsCards.getMedicalInsurancePolicy().getPolicyNumber() == policyNumber)
                .findFirst().orElse(null);
    }

    public PatientsCard[] getPatientsCards(String address) {
        return Arrays.stream(patientsCards)
                .filter(patientsCards -> address.equals(patientsCards.getAddress()))
                .toArray(PatientsCard[]::new);
    }

    public void removePatientsCard(int policyNumber) {
        patientsCards = Arrays.stream(patientsCards)
                .filter(patientsCard ->
                        patientsCard.getMedicalInsurancePolicy().getPolicyNumber() != policyNumber)
                .toArray(PatientsCard[]::new);
    }

    public void addPatientsCard(PatientsCard patientsCard) {
        patientsCards = Arrays.copyOf(patientsCards, patientsCards.length + 1);
        patientsCards[patientsCards.length - 1] = patientsCard;
    }

    public PatientsCard[] getPatientsCards() {
        return patientsCards;
    }

    public PatientsCard[] getSortedPatientsCardsByAddress() {
        PatientsCard[] newPatientsCards = patientsCards.clone();
        Arrays.sort(newPatientsCards, Comparator.comparing(PatientsCard::getAddress));
        return newPatientsCards;
    }

    public int obligatoryMPQuantity() {
        return Arrays.stream(patientsCards)
                .filter(patientsCard -> patientsCard
                        .getMedicalInsurancePolicy() instanceof ObligatoryMedicalInsurancePolicy)
                .toArray().length;
    }

    public int voluntaryMPQuantity() {
        return Arrays.stream(patientsCards)
                .filter(patientsCard -> patientsCard
                        .getMedicalInsurancePolicy() instanceof VoluntaryMedicalInsurancePolicy)
                .toArray().length;
    }

    public int getTotalPaidPatientsQuantity() {
        int amt = 0;
        for (PatientsCard patientsCard : patientsCards) {
            if (patientsCard instanceof PaidPatientsCard) {
                PaidPatientsCard paidPatientsCard = (PaidPatientsCard) patientsCard;
                if (paidPatientsCard.getBills().size() > 0) {
                    amt++;
                }
            }
        }
        return amt;
    }

    public int totalBilledAmount(Date date) {
        int sum = 0;
        for (PatientsCard patientsCard : patientsCards) {
            if (patientsCard instanceof PaidPatientsCard) {
                PaidPatientsCard paidPatientsCard = (PaidPatientsCard) patientsCard;
                for(Bill b : paidPatientsCard.getBills()) {
                    if (date.getMonth() == b.getDate().getMonth() && date.getYear() == b.getDate().getYear()) {
                        sum += b.getSum();
                    }
                }
            }
        }
        return sum;
    }

    @Override
    public String toString() {
        return "Polyclinic{" +
                "number=" + number +
                ", address='" + address + '\'' +
                ", patientsCards=" + Arrays.toString(patientsCards) +
                '}';
    }
}
