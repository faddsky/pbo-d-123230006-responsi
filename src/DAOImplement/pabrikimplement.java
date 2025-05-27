package DAOImplement;

import java.util.List;
import model.*;

public interface pabrikimplement {
    public void create(pabrik p);
    public void edit (pabrik p);
    public void delete (String NamaProduk);
    public List<pabrik> getAll();
}
