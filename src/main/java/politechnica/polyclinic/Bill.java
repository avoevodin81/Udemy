package politechnica.polyclinic;

import java.util.Arrays;
import java.util.Date;

public class Bill {

    private Date date;
    private int sum;
    private MedicineService[] medicineServices = {MedicineService.DENTISTRY,
            MedicineService.ENDOCRINOLOGY, MedicineService.SURGERY};

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public MedicineService[] getMedicineServices() {
        return medicineServices;
    }

    public void setMedicineServices(MedicineService[] medicineServices) {
        this.medicineServices = medicineServices;
    }

    private enum MedicineService {
        DENTISTRY, ENDOCRINOLOGY, SURGERY
    }

    @Override
    public String toString() {
        return "Bill{" +
                "date=" + date.getDate() + "." + date.getMonth() + "." + date.getYear() +
                ", sum=" + sum +
                ", medicineServices=" + Arrays.toString(medicineServices) +
                '}';
    }
}
