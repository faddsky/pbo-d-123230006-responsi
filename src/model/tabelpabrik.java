package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class tabelpabrik extends AbstractTableModel {
    List<pabrik> list;
    
    public tabelpabrik(List<pabrik> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
       return 8; 
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        pabrik p = list.get(rowIndex);
        switch(columnIndex) {
            case 0:
                return p.getNamaProduk();
            case 1:
                return p.getBiayaTenagaKerja();
            case 2:
                return p.getEfisiensiProduk();
            case 3:
                return p.getTotalBiayaProduksi();
            case 4:
                return p.getJumlahUnit();
            case 5:
                return p.getJamKerja();
            case 6:
                return p.getJumlahTenagaKerja();
            case 7:
                return p.getBiayaBahanBaku();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0:
                return "Nama Produk";
            case 1:
                return "Biaya Tenaga Kerja";
            case 2:
                return "Efisiensi Produk";
            case 3:
                return "Total Biaya Produksi";
            case 4:
                return "Jumlah Unit";
            case 5:
                return "Jam Kerja";
            case 6:
                return "Jumlah Tenaga Kerja";
            case 7:
                return "Biaya Bahan Baku";
            default:
                return null;
        }
    }
}
