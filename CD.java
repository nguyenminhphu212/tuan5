
import java.text.MessageFormat;

public class CD {

    // ================= THUOC TINH =================
    private int maCD;
    private String tuaCD;
    private String caSi;
    private int soBaiHat;
    private float giaThanh;

    // ================= CONSTRUCTOR =================
    public CD(int maCD, String tuaCD, String caSi,
              int soBaiHat, float giaThanh) {

        this.maCD = maCD;
        this.tuaCD = tuaCD;
        this.caSi = caSi;

        setSoBaiHat(soBaiHat);
        setGiaThanh(giaThanh);
    }

    // ================= SETTER =================
    public void setMaCD(int maCD) {
        this.maCD = maCD;
    }

    public void setTuaCD(String tuaCD) {
        this.tuaCD = tuaCD;
    }

    public void setCaSi(String caSi) {
        this.caSi = caSi;
    }

    public void setSoBaiHat(int soBaiHat) {

        if (soBaiHat > 0) {
            this.soBaiHat = soBaiHat;
        } else {
            throw new IllegalArgumentException(
                "So bai hat phai lon hon 0!"
            );
        }
    }

    public void setGiaThanh(float giaThanh) {

        if (giaThanh > 0 && Float.isFinite(giaThanh)) {
            this.giaThanh = giaThanh;
        } else {
            throw new IllegalArgumentException(
                "Gia thanh phai lon hon 0!"
            );
        }
    }

    // ================= GETTER =================
    public int getMaCD() {
        return maCD;
    }

    public String getTuaCD() {
        return tuaCD;
    }

    public String getCaSi() {
        return caSi;
    }

    public int getSoBaiHat() {
        return soBaiHat;
    }

    public float getGiaThanh() {
        return giaThanh;
    }

    // ================= TOSTRING =================
    @Override
    public String toString() {

        return MessageFormat.format(
            "{0} | {1} | {2} | {3} | {4}",
            maCD,
            tuaCD,
            caSi,
            soBaiHat,
            giaThanh
        );
    }
}
