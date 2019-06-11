package hu.nl.hibernate;

public class OVChipkaartService {

	private static OVChipkaartService instance;
	private OVChipkaartDaoImpl OVChipkaartDaoImpl;

	public static OVChipkaartService getInstance() {
		if (instance == null)
			instance = new OVChipkaartService();
		return instance;
	}

	public OVChipkaartService() {
		OVChipkaartDaoImpl = new OVChipkaartDaoImpl();
	}

	public void persist(OVChipkaart entity) {
		OVChipkaartDaoImpl.openCurrentSessionwithTransaction();
		OVChipkaartDaoImpl.persist(entity);
		OVChipkaartDaoImpl.closeCurrentSessionwithTransaction();
	}

	public void update(OVChipkaart entity) {
		OVChipkaartDaoImpl.openCurrentSessionwithTransaction();
		OVChipkaartDaoImpl.update(entity);
		OVChipkaartDaoImpl.closeCurrentSessionwithTransaction();
	}

	public OVChipkaart findById(int id) {
		OVChipkaartDaoImpl.openCurrentSession();
		OVChipkaart ovChipkaart = OVChipkaartDaoImpl.findById(id);
		OVChipkaartDaoImpl.closeCurrentSession();
		return ovChipkaart;
	}

	public void delete(int id) {
		OVChipkaartDaoImpl.openCurrentSessionwithTransaction();
		OVChipkaart ovChipkaart = OVChipkaartDaoImpl.findById(id);
		OVChipkaartDaoImpl.delete(ovChipkaart);
		OVChipkaartDaoImpl.closeCurrentSessionwithTransaction();
	}

	public void delete(OVChipkaart ovchipkaart) {
		OVChipkaartDaoImpl.openCurrentSessionwithTransaction();
		OVChipkaartDaoImpl.delete(ovchipkaart);
		OVChipkaartDaoImpl.closeCurrentSessionwithTransaction();
	}

	public OVChipkaartDaoImpl getOvChipkaartDao() {
		return OVChipkaartDaoImpl;
	}
}
