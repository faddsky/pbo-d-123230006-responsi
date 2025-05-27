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
        dp.setJudul(frame.getjTextFieldJudul().getText());
        dp.setAlur(Float.parseFloat(frame.getjTextFieldAlur().getText()));
        dp.setPenokohan(Float.parseFloat(frame.getjTextFieldPenokohan().getText()));
        dp.setAkting(Float.parseFloat(frame.getjTextFieldAkting().getText()));
        implfilm.insert(dp);
        isitable();
        clear();
        JOptionPane.showMessageDialog(frame, "Data berhasil ditambahkan!");
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(frame, "Input nilai harus angka!");
    }
}


    public void update() {
    try {
        int id = Integer.parseInt(frame.getjTextFieldID().getText());
        if (id <= 0) {
            JOptionPane.showMessageDialog(frame, "ID tidak valid untuk update!");
            return;
        }
        Film dp = new Film();
        dp.setID(id);
        dp.setJudul(frame.getjTextFieldJudul().getText());
        dp.setAlur(Float.parseFloat(frame.getjTextFieldAlur().getText()));
        dp.setPenokohan(Float.parseFloat(frame.getjTextFieldPenokohan().getText()));
        dp.setAkting(Float.parseFloat(frame.getjTextFieldAkting().getText()));
        implfilm.update(dp);
        isitable();
        clear();
        JOptionPane.showMessageDialog(frame, "Data berhasil diupdate!");
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(frame, "Input nilai harus angka dan ID harus valid!");
    }
}


    public void delete() {
    try {
        int id = Integer.parseInt(frame.getjTextFieldID().getText());
        implfilm.delete(id); 
        isitable();         
        clear();             
        JOptionPane.showMessageDialog(frame, "Data berhasil dihapus!");
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(frame, "ID tidak valid atau kosong!");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(frame, "Error hapus data: " + e.getMessage());
    }
    }

    public void clear() {
        frame.getjTextFieldJudul().setText("");
        frame.getjTextFieldAlur().setText("");
        frame.getjTextFieldPenokohan().setText("");
        frame.getjTextFieldAkting().setText("");
        frame.getjTextFieldID().setText("");
    }
}
