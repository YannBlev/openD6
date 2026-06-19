package bzh.amzerin.openD6.dal;

import java.util.List;

import bzh.amzerin.openD6.bo.Skill;

public interface SkillDao {

	List<Skill> getSkills();
	Skill getSkillById(int id);
	void createSkill(Skill capacity);
	void deleteSkillById(int id);

}
