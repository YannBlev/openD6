package bzh.amzerin.openD6.service.impl;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import bzh.amzerin.openD6.bo.Universe;
import bzh.amzerin.openD6.dal.UniverseDao;
import bzh.amzerin.openD6.service.UniverseService;
import lombok.AllArgsConstructor;

@Service
@Profile("mock")
@AllArgsConstructor
public class UniverseServiceMock implements UniverseService{

	UniverseDao universeDao;
	
	@Override
	public List<Universe> getUniverses() {
		return universeDao.getUniverses();
	}

	@Override
	public Universe getUniverseById(int id) {
		return universeDao.getUniverseById(id);
	}

	@Override
	public void createUniverse(Universe universe) {
		universeDao.createUniverse(universe);
		
	}

	@Override
	public void deleteUniverseById(int id) {
		universeDao.deleteUniverseById(id);
		
	}

}
