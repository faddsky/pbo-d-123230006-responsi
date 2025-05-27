package model;

public class pabrik {
    private String namaProduk;
    private int jumlahUnit;
    private int jamKerja;
    private int jumlahTenagaKerja;
    private int biayaBahanBaku;
    private int biayaTenagaKerja;
    private float efisiensiProduk;
    private int totalBiayaProduksi;

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public int getJumlahUnit() {
        return jumlahUnit;
    }

    public void setJumlahUnit(int jumlahUnit) {
        this.jumlahUnit = jumlahUnit;
    }

    public int getJamKerja() {
        return jamKerja;
    }

    public void setJamKerja(int jamKerja) {
        this.jamKerja = jamKerja;
    }

    public int getJumlahTenagaKerja() {
        return jumlahTenagaKerja;
    }

    public void setJumlahTenagaKerja(int jumlahTenagaKerja) {
        this.jumlahTenagaKerja = jumlahTenagaKerja;
    }

    public int getBiayaBahanBaku() {
        return biayaBahanBaku;
    }

    public void setBiayaBahanBaku(int biayaBahanBaku) {
        this.biayaBahanBaku = biayaBahanBaku;
    }

    public int getBiayaTenagaKerja() {
        return jamKerja * jumlahTenagaKerja * 15000;
    }

    public float getEfisiensiProduk() {
        if (jamKerja * jumlahTenagaKerja == 0) return 0;
        return ((float) jumlahUnit / (jamKerja * jumlahTenagaKerja)) * 100;
    }

    public int getTotalBiayaProduksi() {
        return biayaBahanBaku + getBiayaTenagaKerja();
    }

    public void setBiayaTenagaKerja(int biayaTenagaKerja) {
        this.biayaTenagaKerja = biayaTenagaKerja;
    }

    public void setEfisiensiProduk(float efisiensiProduk) {
        this.efisiensiProduk = efisiensiProduk;
    }

    public void setTotalBiayaProduksi(int totalBiayaProduksi) {
        this.totalBiayaProduksi = totalBiayaProduksi;
    }
}
