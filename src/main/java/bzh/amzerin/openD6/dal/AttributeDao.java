package bzh.amzerin.openD6.dal;

import java.util.List;

import bzh.amzerin.openD6.bo.Attribute;

public interface AttributeDao {

	List<Attribute> getAttributes();
	Attribute getAttributeById(int id);
	void createAttribute(Attribute attribute);
	void deleteAttributeById(int id);
	
}