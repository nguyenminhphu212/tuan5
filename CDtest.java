
import java.util.Scanner;

public class CDtest {

    static Scanner sc = new Scanner(System.in);

    // ================= NHAP SO NGUYEN =================
    public static int nhapSoNguyen(String thongBao) {

        while (true) {

            System.out.print(thongBao);

            try {
                return Integer.parseInt(sc.nextLine().trim());

            } catch (NumberFormatException e) {

                System.out.println("Vui long nhap so nguyen!");
            }
        }
    }

    // ================= NHAP SO THUC =================
    public static float nhapSoThuc(String thongBao) {

        while (true) {

            System.out.print(thongBao);

            try {

                float giaTri = Float.parseFloat(sc.nextLine().trim());

                if (!Float.isFinite(giaTri)) {
                    System.out.println("Gia tri khong hop le!");
                    continue;
                }

                return giaTri;

            } catch (NumberFormatException e) {

                System.out.println("Vui long nhap so thuc!");
            }
        }
    }

    // ================= NHAP CHUOI =================
    public static String nhapChuoi(String thongBao) {

        String chuoi;

        do {

            System.out.print(thongBao);

            chuoi = sc.nextLine().trim();

            if (chuoi.isEmpty()) {
                System.out.println("Thong tin khong duoc de trong!");
            }

        } while (chuoi.isEmpty());

        return chuoi;
    }

    // ================= NHAP CD =================
    public static CD nhapCD() {

        int maCD;
        String tuaCD;
        String caSi;
        int soBaiHat;
        float giaThanh;

        maCD = nhapSoNguyen("Nhap ma CD: ");

        tuaCD = nhapChuoi("Nhap tua CD: ");

        caSi = nhapChuoi("Nhap ten ca si: ");

        do {

            soBaiHat = nhapSoNguyen("Nhap so bai hat: ");

            if (soBaiHat <= 0) {
                System.out.println("So bai hat phai lon hon 0!");
            }

        } while (soBaiHat <= 0);

        do {

            giaThanh = nhapSoThuc("Nhap gia thanh: ");

            if (giaThanh <= 0) {
                System.out.println("Gia thanh phai lon hon 0!");
            }

        } while (giaThanh <= 0);

        return new CD(maCD, tuaCD, caSi, soBaiHat, giaThanh);
    }

    // ================= MENU =================
    public static void hienThiMenu() {

        System.out.println("\n========== QUAN LY CD ==========");
        System.out.println("1. Them CD");
        System.out.println("2. Xoa CD");
        System.out.println("3. Cap nhat CD");
        System.out.println("4. Tim CD theo ma");
        System.out.println("5. Tim CD theo tien to");
        System.out.println("6. Tim CD theo hau to");
        System.out.println("7. Tim CD gan giong");
        System.out.println("8. Hien thi danh sach CD");
        System.out.println("9. Thong ke danh sach");
        System.out.println("10. Tim CD dat nhat");
        System.out.println("11. Tim CD re nhat");
        System.out.println("12. Sap xep giam dan theo gia");
        System.out.println("13. Sap xep tang dan theo tua");
        System.out.println("0. Thoat");
        System.out.println("================================");
    }

    // ================= MAIN =================
    public static void main(String[] args) {

        CDList ds = new CDList();

        int luaChon;

        do {

            hienThiMenu();

            luaChon = nhapSoNguyen("Nhap lua chon: ");

            switch (luaChon) {

                // -------- THEM CD --------
                case 1: {

                    CD cd = nhapCD();

                    if (ds.themCD(cd)) {
                        System.out.println("Them CD thanh cong!");
                    }

                    break;
                }

                // -------- XOA CD --------
                case 2: {

                    int maCD = nhapSoNguyen("Nhap ma CD can xoa: ");

                    if (ds.xoaCD(maCD)) {
                        System.out.println("Xoa CD thanh cong!");
                    } else {
                        System.out.println("Khong tim thay CD!");
                    }

                    break;
                }

                // -------- CAP NHAT CD --------
                case 3: {

                    int maCD = nhapSoNguyen("Nhap ma CD can cap nhat: ");

                    String tuaMoi = nhapChuoi("Nhap tua CD moi: ");

                    String caSiMoi = nhapChuoi("Nhap ten ca si moi: ");

                    int soBaiMoi;

                    do {

                        soBaiMoi = nhapSoNguyen("Nhap so bai hat moi: ");

                        if (soBaiMoi <= 0) {
                            System.out.println("So bai hat phai lon hon 0!");
                        }

                    } while (soBaiMoi <= 0);

                    float giaMoi;

                    do {

                        giaMoi = nhapSoThuc("Nhap gia thanh moi: ");

                        if (giaMoi <= 0) {
                            System.out.println("Gia thanh phai lon hon 0!");
                        }

                    } while (giaMoi <= 0);

                    if (ds.capNhatCD(maCD, tuaMoi, caSiMoi,
                                    soBaiMoi, giaMoi)) {

                        System.out.println("Cap nhat thanh cong!");

                    } else {

                        System.out.println("Khong tim thay CD hoac du lieu khong hop le!");
                    }

                    break;
                }

                // -------- TIM THEO MA --------
                case 4: {

                    int maCD = nhapSoNguyen("Nhap ma CD can tim: ");

                    CD cd = ds.timTheoMa(maCD);

                    if (cd != null) {

                        System.out.println("Ket qua tim kiem:");
                        System.out.println(cd);

                    } else {

                        System.out.println("Khong tim thay CD!");
                    }

                    break;
                }

                // -------- TIM THEO TIEN TO --------
                case 5: {

                    String tuKhoa = nhapChuoi("Nhap tien to can tim: ");

                    CDList ketQua = ds.timTheoTienTo(tuKhoa);

                    System.out.println("Ket qua tim kiem:");

                    ketQua.hienThiDanhSach();

                    break;
                }

                // -------- TIM THEO HAU TO --------
                case 6: {

                    String tuKhoa = nhapChuoi("Nhap hau to can tim: ");

                    CDList ketQua = ds.timTheoHauTo(tuKhoa);

                    System.out.println("Ket qua tim kiem:");

                    ketQua.hienThiDanhSach();

                    break;
                }

                // -------- TIM GAN GIONG --------
                case 7: {

                    String tuKhoa = nhapChuoi("Nhap tu khoa can tim: ");

                    CDList ketQua = ds.timGanGiong(tuKhoa);

                    System.out.println("Ket qua tim kiem:");

                    ketQua.hienThiDanhSach();

                    break;
                }

                // -------- HIEN THI --------
                case 8: {

                    ds.hienThiDanhSach();

                    break;
                }

                // -------- THONG KE --------
                case 9: {

                    System.out.println("So luong CD: "
                            + ds.tinhSoLuongCD());

                    System.out.println("Tong gia thanh: "
                            + ds.tinhTongGiaThanh());

                    System.out.println("Gia trung binh: "
                            + ds.tinhGiaTrungBinh());

                    break;
                }

                // -------- CD DAT NHAT --------
                case 10: {

                    CD cd = ds.timCDDatNhat();

                    if (cd != null) {

                        System.out.println("CD dat nhat:");
                        System.out.println(cd);

                    } else {

                        System.out.println("Danh sach CD trong!");
                    }

                    break;
                }

                // -------- CD RE NHAT --------
                case 11: {

                    CD cd = ds.timCDReNhat();

                    if (cd != null) {

                        System.out.println("CD re nhat:");
                        System.out.println(cd);

                    } else {

                        System.out.println("Danh sach CD trong!");
                    }

                    break;
                }

                // -------- SAP XEP GIA --------
                case 12: {

                    ds.sapXepGiamDanTheoGia();

                    ds.hienThiDanhSach();

                    break;
                }

                // -------- SAP XEP TUA --------
                case 13: {

                    ds.sapXepTangDanTheoTua();

                    ds.hienThiDanhSach();

                    break;
                }

                // -------- THOAT --------
                case 0: {

                    System.out.println("Ket thuc chuong trinh!");

                    break;
                }

                default: {

                    System.out.println("Lua chon khong hop le!");

                    break;
                }
            }

        } while (luaChon != 0);

        sc.close();
    }
}
