package DAOPabrik;

import java.sql.*;
import java.util.*;
import koneksi.connection;
import model.pabrik;
import DAOImplement.pabrikimplement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class pabrikDAO implements pabrikimplement {
    private final Connection connection;

    private static final String SELECT_ALL = "SELECT * FROM pabrik";
    private static final String INSERT = "INSERT INTO pabrik(NamaProduk, BiayaTenagaKerja, EfisiensiProduk, TotalBiayaProduksi, JumlahUnit, JamKerja, JumlahTenagaKerja, BiayaBahanBaku) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE pabrik SET NamaProduk=?, BiayaTenagaKerja=?, EfisiensiProduk=?, TotalBiayaProduksi=?, JumlahUnit=?, JamKerja=?, JumlahTenagaKerja=?, BiayaBahanBaku=? WHERE NamaProduk=?";
    private static final String DELETE = "DELETE FROM pabrik WHERE NamaProduk=?";

    public pabrikDAO() {
        this.connection = connection.connection();
    }

    @Override
    public void create(pabrik p) {
        try (PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setString(1, p.getNamaProduk());
            statement.setInt(2, p.getBiayaTenagaKerja());
            statement.setFloat(3, p.getEfisiensiProduk());
            statement.setInt(4, p.getTotalBiayaProduksi());
            statement.setInt(5, p.getJumlahUnit());
            statement.setInt(6, p.getJamKerja());
            statement.setInt(7, p.getJumlahTenagaKerja());
            statement.setInt(8, p.getBiayaBahanBaku());
            statement.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(pabrikDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void edit(pabrik p) {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, p.getNamaProduk());
            statement.setInt(2, p.getBiayaTenagaKerja());
            statement.setFloat(3, p.getEfisiensiProduk());
            statement.setInt(4, p.getTotalBiayaProduksi());
            statement.setInt(5, p.getJumlahUnit());
            statement.setInt(6, p.getJamKerja());
            statement.setInt(7, p.getJumlahTenagaKerja());
            statement.setInt(8, p.getBiayaBahanBaku());
            statement.setString(9, p.getNamaProduk()); // WHERE NamaProduk = ?
            statement.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(pabrikDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void delete(String NamaProduk) {
        try (PreparedStatement statement = connection.prepareStatement(DELETE)) {
            statement.setString(1, NamaProduk);
            statement.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(pabrikDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public List<pabrik> getAll() {
        List<pabrik> pabrikList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                pabrik p = new pabrik();
                p.setNamaProduk(rs.getString("NamaProduk"));
                p.setBiayaTenagaKerja(rs.getInt("BiayaTenagaKerja"));
                p.setEfisiensiProduk(rs.getFloat("EfisiensiProduk"));
                p.setTotalBiayaProduksi(rs.getInt("TotalBiayaProduksi"));
                p.setJumlahUnit(rs.getInt("JumlahUnit"));
                p.setJamKerja(rs.getInt("JamKerja"));
                p.setJumlahTenagaKerja(rs.getInt("JumlahTenagaKerja"));
                p.setBiayaBahanBaku(rs.getInt("BiayaBahanBaku"));
                pabrikList.add(p);
            }
        } catch (SQLException e) {
            Logger.getLogger(pabrikDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return pabrikList;
    }
}
