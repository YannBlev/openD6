package bzh.amzerin.openD6.service;

import java.util.List;

import bzh.amzerin.openD6.bo.Universe;

public interface UniverseService {
	List<Universe> getUniverses();
	Universe getUniverseById(int id);
	void createUniverse(Universe universe);
	void deleteUniverseById(int id);
}
