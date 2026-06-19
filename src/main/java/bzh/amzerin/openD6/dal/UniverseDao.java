package bzh.amzerin.openD6.dal;

import java.util.List;

import bzh.amzerin.openD6.bo.Universe;

public interface UniverseDao {

	List<Universe> getUniverses();
	Universe getUniverseById(int id);
	void createUniverse(Universe universe);
	void deleteUniverseById(int id);
	
}
