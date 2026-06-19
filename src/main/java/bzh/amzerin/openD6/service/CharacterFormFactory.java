package bzh.amzerin.openD6.service;

import org.springframework.stereotype.Service;

import bzh.amzerin.openD6.bo.Attribute;
import bzh.amzerin.openD6.bo.AttributeForm;
import bzh.amzerin.openD6.bo.CharacterForm;
import bzh.amzerin.openD6.bo.Game;
import bzh.amzerin.openD6.bo.Skill;
import bzh.amzerin.openD6.bo.SkillForm;

@Service
public class CharacterFormFactory {

    public CharacterForm build(Game game) {

    	    CharacterForm form = new CharacterForm();

    	    for (Attribute attr : game.getUniverse().getAttributes()) {

    	        AttributeForm attrForm = new AttributeForm();
    	        attrForm.setAttributeId(attr.getId());
    	        attrForm.setPipValue(3);

    	        for (Skill skill : attr.getSkills()) {

    	            SkillForm skillForm = new SkillForm();
    	            skillForm.setSkillId(skill.getId());
    	            skillForm.setPipValue(0);

    	            attrForm.getSkills().add(skillForm);
    	        }

    	        form.getAttributes().add(attrForm);
    	    }

    	    return form;
    }
}