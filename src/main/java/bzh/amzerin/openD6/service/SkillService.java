package bzh.amzerin.openD6.service;

import java.util.List;

import bzh.amzerin.openD6.bo.Skill;

public interface SkillService {
	
	List<Skill> getSkills();
	Skill getSkillById(int id);
	void createSkill(Skill skill);
	void deleteSkillById(int id);
	
}
