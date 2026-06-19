package bzh.amzerin.openD6.service.impl;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import bzh.amzerin.openD6.bo.Skill;
import bzh.amzerin.openD6.dal.SkillDao;
import bzh.amzerin.openD6.service.SkillService;
import lombok.AllArgsConstructor;

@Service
@Profile("mock")
@AllArgsConstructor
public class SkillServiceMock implements SkillService{

	SkillDao skillDao;
	
	@Override
	public List<Skill> getSkills() {
		return skillDao.getSkills();
	}

	@Override
	public Skill getSkillById(int id) {
		return skillDao.getSkillById(id);
	}

	@Override
	public void createSkill(Skill skill) {
		skillDao.createSkill(skill);
	}

	@Override
	public void deleteSkillById(int id) {
		skillDao.deleteSkillById(id);
	}

}
