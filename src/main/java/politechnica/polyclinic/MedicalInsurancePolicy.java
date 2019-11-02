package politechnica.polyclinic;

public abstract class MedicalInsurancePolicy {

    private static final int POLICY_NUMBER = 0;
    private static final String DEFAULT_NAME = "";
    private int policyNumber;
    private String name;

    public MedicalInsurancePolicy() {
        this.policyNumber = POLICY_NUMBER;
        this.name = DEFAULT_NAME;
    }

    public MedicalInsurancePolicy(int policyNumber, String name) {
        this.policyNumber = policyNumber;
        this.name = name;
    }

    public int getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MedicalInsurancePolicy{" +
                "\n    policyNumber=" + policyNumber +
                ", name='" + name + '\'' +
                '}';
    }
}
