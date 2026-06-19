package bzh.amzerin.openD6.service;

import java.util.List;

import bzh.amzerin.openD6.bo.Attribute;

public interface AttributeService {
	List<Attribute> getAttributes();
	Attribute getAttributeById(int id);
	void createAttribute(Attribute attribvute);
	void deleteAttributeById(int id);
}
