package controller;

import java.util.List;
import DAOPabrik.pabrikDAO;
import DAOImplement.pabrikimplement;
import javax.swing.JOptionPane;
import model.pabrik;
import model.tabelpabrik;
import view.mainview;

public class pabrikcontroller {
    mainview frame;
    pabrikimplement implpabrik;
    List<Film> dp;

    public pabrikcontroller(mainview frame) {
        this.frame = frame;
        implpabrik = new pabrikDAO();
        dp = implpabrik.getAll();
    }

    public void isitable() {
        dp = implpabrik.getAll();
        tabelpabrik np = new tabelpabrik(dp);
        frame.getjtabelpabrik().setModel(np);
    }

    public void insert() {
    try {
        pabrik dp = new pabrik();
        dp.setNamaProduk(frame.getjTextFieldNamaProduk().getText());
        dp.setBiayaTenagaKerja(Int.parseInt(frame.getjTextFieldBiayaTenagaKerja().getText()));
        dp.setEfisiensiProduk(Float.parseFloat(frame.getjTextFieldEfisiensiProduk().getText()));
        dp.setTotalBiayaProduksi(Float.parseFloat(frame.getjTextFieldTotalBiayaProduksi().getText()));
        implpabrik.insert(dp);
        isitable();
        clear();
        JOptionPane.showMessageDialog(frame, "Data berhasil ditambahkan!");
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(frame, "Input nilai harus angka!");
    }
}