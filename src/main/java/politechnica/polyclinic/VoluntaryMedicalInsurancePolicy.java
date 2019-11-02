package politechnica.polyclinic;

public class VoluntaryMedicalInsurancePolicy extends MedicalInsurancePolicy {

    private static final int TOTAL_INSURANCE_AMOUNT = 100000;
    private static final int TOTAL_PAID_AMOUNT = 0;
    private int totalInsuranceAmount;
    private int totalPaidAmount;

    public VoluntaryMedicalInsurancePolicy() {
        this.totalInsuranceAmount = TOTAL_INSURANCE_AMOUNT;
        this.totalPaidAmount = TOTAL_PAID_AMOUNT;
    }

    public VoluntaryMedicalInsurancePolicy(int totalInsuranceAmount) {
        this.totalInsuranceAmount = totalInsuranceAmount;
        this.totalPaidAmount = TOTAL_PAID_AMOUNT;
    }

    public int getTotalInsuranceAmount() {
        return totalInsuranceAmount;
    }

    public void setTotalInsuranceAmount(int totalInsuranceAmount) {
        this.totalInsuranceAmount = totalInsuranceAmount;
    }

    public int getTotalPaidAmount() {
        return totalPaidAmount;
    }

    public void setTotalPaidAmount(int totalPaidAmount) {
        this.totalPaidAmount = totalPaidAmount;
    }

    @Override
    public String toString() {
        return super.toString() + "\n    VoluntaryMedicalInsurancePolicy{" +
                "\n        totalInsuranceAmount=" + totalInsuranceAmount +
                ", totalPaidAmount=" + totalPaidAmount +
                "}";
    }
}
