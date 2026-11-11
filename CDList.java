
public class CDList {

    // ================= THUOC TINH =================
    private CD[] danhSachCD;
    private int soLuong;
    private int khaNang;

    private static final int KICH_THUOC_BAN_DAU = 5;

    // ================= CONSTRUCTOR =================
    public CDList() {

        khaNang = KICH_THUOC_BAN_DAU;
        danhSachCD = new CD[khaNang];
        soLuong = 0;
    }

    // ================= GETTER =================
    public int laySoLuong() {
        return soLuong;
    }

    public int layKhaNang() {
        return khaNang;
    }

    public CD layCDTaiViTri(int viTri) {

        if (viTri < 0 || viTri >= soLuong) {
            return null;
        }

        return danhSachCD[viTri];
    }

    // ================= MO RONG MANG =================
    private void moRongMang() {

        int kichThuocMoi = khaNang * 2;

        CD[] mangMoi = new CD[kichThuocMoi];

        for (int i = 0; i < soLuong; i++) {
            mangMoi[i] = danhSachCD[i];
        }

        danhSachCD = mangMoi;
        khaNang = kichThuocMoi;

        System.out.println(
            "Da mo rong mang len " + khaNang + " phan tu."
        );
    }

    // ================= TIM VI TRI THEO MA =================
    public int timViTriTheoMa(int maCD) {

        for (int i = 0; i < soLuong; i++) {

            if (danhSachCD[i].getMaCD() == maCD) {
                return i;
            }
        }

        return -1;
    }

    // ================= THEM CD =================
    public boolean themCD(CD cd) {

        if (cd == null) {
            System.out.println("CD khong hop le!");
            return false;
        }

        if (timViTriTheoMa(cd.getMaCD()) != -1) {

            System.out.println(
                "Ma CD " + cd.getMaCD() + " da ton tai!"
            );

            return false;
        }

        if (soLuong == khaNang) {
            moRongMang();
        }

        danhSachCD[soLuong] = cd;
        soLuong++;

        return true;
    }

    // ================= XOA CD =================
    public boolean xoaCD(int maCD) {

        int viTri = timViTriTheoMa(maCD);

        if (viTri == -1) {
            return false;
        }

        // Dich cac phan tu sang trai
        for (int i = viTri; i < soLuong - 1; i++) {

            danhSachCD[i] = danhSachCD[i + 1];
        }

        // Xoa phan tu cuoi
        danhSachCD[soLuong - 1] = null;

        soLuong--;

        return true;
    }

    // ================= CAP NHAT CD =================
    public boolean capNhatCD(int maCD, String tuaMoi,
                             String caSiMoi, int soBaiMoi,
                             float giaMoi) {

        int viTri = timViTriTheoMa(maCD);

        if (viTri == -1) {
            return false;
        }

        if (tuaMoi == null || tuaMoi.trim().isEmpty()
                || caSiMoi == null || caSiMoi.trim().isEmpty()
                || soBaiMoi <= 0 || giaMoi <= 0
                || !Float.isFinite(giaMoi)) {

            return false;
        }

        CD cd = danhSachCD[viTri];

        cd.setTuaCD(tuaMoi);
        cd.setCaSi(caSiMoi);
        cd.setSoBaiHat(soBaiMoi);
        cd.setGiaThanh(giaMoi);

        return true;
    }

    // ================= TIM THEO MA =================
    public CD timTheoMa(int maCD) {

        int viTri = timViTriTheoMa(maCD);

        if (viTri == -1) {
            return null;
        }

        return danhSachCD[viTri];
    }

    // ================= TIM THEO TIEN TO =================
    public CDList timTheoTienTo(String tuKhoa) {

        CDList ketQua = new CDList();

        if (tuKhoa == null || tuKhoa.trim().isEmpty()) {
            return ketQua;
        }

        String tk = tuKhoa.trim().toLowerCase();

        for (int i = 0; i < soLuong; i++) {

            String tua = danhSachCD[i]
                    .getTuaCD().toLowerCase();

            if (tua.startsWith(tk)) {
                ketQua.themCD(danhSachCD[i]);
            }
        }

        return ketQua;
    }

    // ================= TIM THEO HAU TO =================
    public CDList timTheoHauTo(String tuKhoa) {

        CDList ketQua = new CDList();

        if (tuKhoa == null || tuKhoa.trim().isEmpty()) {
            return ketQua;
        }

        String tk = tuKhoa.trim().toLowerCase();

        for (int i = 0; i < soLuong; i++) {

            String tua = danhSachCD[i]
                    .getTuaCD().toLowerCase();

            if (tua.endsWith(tk)) {
                ketQua.themCD(danhSachCD[i]);
            }
        }

        return ketQua;
    }

    // ================= TIM GAN GIONG =================
    public CDList timGanGiong(String tuKhoa) {

        CDList ketQua = new CDList();

        if (tuKhoa == null || tuKhoa.trim().isEmpty()) {
            return ketQua;
        }

        String tk = tuKhoa.trim().toLowerCase();

        for (int i = 0; i < soLuong; i++) {

            String tua = danhSachCD[i]
                    .getTuaCD().toLowerCase();

            if (tua.contains(tk)) {
                ketQua.themCD(danhSachCD[i]);
            }
        }

        return ketQua;
    }

    // ================= THONG KE =================
    public int tinhSoLuongCD() {
        return soLuong;
    }

    public double tinhTongGiaThanh() {

        double tong = 0;

        for (int i = 0; i < soLuong; i++) {

            tong += danhSachCD[i].getGiaThanh();
        }

        return tong;
    }

    public double tinhGiaTrungBinh() {

        if (soLuong == 0) {
            return 0;
        }

        return tinhTongGiaThanh() / soLuong;
    }

    // ================= TIM CD DAT NHAT =================
    public CD timCDDatNhat() {

        if (soLuong == 0) {
            return null;
        }

        CD max = danhSachCD[0];

        for (int i = 1; i < soLuong; i++) {

            if (danhSachCD[i].getGiaThanh()
                    > max.getGiaThanh()) {

                max = danhSachCD[i];
            }
        }

        return max;
    }

    // ================= TIM CD RE NHAT =================
    public CD timCDReNhat() {

        if (soLuong == 0) {
            return null;
        }

        CD min = danhSachCD[0];

        for (int i = 1; i < soLuong; i++) {

            if (danhSachCD[i].getGiaThanh()
                    < min.getGiaThanh()) {

                min = danhSachCD[i];
            }
        }

        return min;
    }

    // ================= HIEN THI DANH SACH =================
    public void hienThiDanhSach() {

        if (soLuong == 0) {

            System.out.println("Danh sach CD trong!");
            return;
        }

        System.out.println("\n================ DANH SACH CD ================");

        System.out.printf(
            "%-10s %-25s %-25s %-15s %-15s%n",
            "Ma CD", "Tua CD", "Ca si", "So bai hat", "Gia thanh"
        );

        System.out.println(
            "--------------------------------------------------------------------------"
        );

        for (int i = 0; i < soLuong; i++) {

            CD cd = danhSachCD[i];

            System.out.printf(
                "%-10d %-25s %-25s %-15d %-15.2f%n",
                cd.getMaCD(),
                cd.getTuaCD(),
                cd.getCaSi(),
                cd.getSoBaiHat(),
                cd.getGiaThanh()
            );
        }

        System.out.println(
            "--------------------------------------------------------------------------"
        );
    }

    // ================= SAP XEP GIAM DAN THEO GIA =================
    public void sapXepGiamDanTheoGia() {

        for (int i = 0; i < soLuong - 1; i++) {

            for (int j = i + 1; j < soLuong; j++) {

                if (danhSachCD[i].getGiaThanh()
                        < danhSachCD[j].getGiaThanh()) {

                    CD temp = danhSachCD[i];

                    danhSachCD[i] = danhSachCD[j];

                    danhSachCD[j] = temp;
                }
            }
        }

        System.out.println("Da sap xep giam dan theo gia!");
    }

    // ================= SAP XEP TANG DAN THEO TUA =================
    public void sapXepTangDanTheoTua() {

        for (int i = 0; i < soLuong - 1; i++) {

            for (int j = i + 1; j < soLuong; j++) {

                if (danhSachCD[i].getTuaCD()
                        .compareToIgnoreCase(
                            danhSachCD[j].getTuaCD()
                        ) > 0) {

                    CD temp = danhSachCD[i];

                    danhSachCD[i] = danhSachCD[j];

                    danhSachCD[j] = temp;
                }
            }
        }

        System.out.println("Da sap xep tang dan theo tua CD!");
    }
}
