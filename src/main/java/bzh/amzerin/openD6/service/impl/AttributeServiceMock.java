package bzh.amzerin.openD6.service.impl;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import bzh.amzerin.openD6.bo.Attribute;
import bzh.amzerin.openD6.dal.AttributeDao;
import bzh.amzerin.openD6.service.AttributeService;
import lombok.AllArgsConstructor;

@Service
@Profile("mock")
@AllArgsConstructor
public class AttributeServiceMock implements AttributeService{

	AttributeDao attributeDao;
	
	@Override
	public List<Attribute> getAttributes() {
		return attributeDao.getAttributes();
	}

	@Override
	public Attribute getAttributeById(int id) {
		return attributeDao.getAttributeById(id);
	}

	@Override
	public void createAttribute(Attribute attribvute) {
		attributeDao.createAttribute(attribvute);
	}

	@Override
	public void deleteAttributeById(int id) {
		attributeDao.deleteAttributeById(id);
	}

}
