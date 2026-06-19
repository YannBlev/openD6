package bzh.amzerin.openD6.dal.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import bzh.amzerin.openD6.bo.Skill;
import bzh.amzerin.openD6.dal.SkillDao;
import jakarta.annotation.PostConstruct;

@Repository
@Profile("mock")
public class SkillDaoMock implements SkillDao{

	private static List<Skill> skills = new ArrayList<Skill>();
	private static int indexSkill = 0;
    
    private final List<Skill> skillsInit = List.of(
	        new Skill(1,"Acrobatie"),
	        new Skill(2,"Armes blanches"),
	        new Skill(3,"Contorsion"),
	        new Skill(4,"Discretion"),
	        new Skill(5,"Equitation"),
	        new Skill(6,"Escalade"),
	        new Skill(7,"Esquive"),
	        new Skill(8,"Lutte"),
	        new Skill(9,"Saut"),
	        new Skill(10,"Vol"),
            new Skill(11,"Chariots"),
            new Skill(12,"Crochetage"),
            new Skill(13,"Lancer"),
            new Skill(14,"Pilotage"),
            new Skill(15,"Prestidigidation"),
            new Skill(16,"Tir"),
            new Skill(17,"Course"),
            new Skill(18,"Nage"),
            new Skill(19,"Puissance"),
            new Skill(20,"Résistance"),
            new Skill(21,"Commerce"),
            new Skill(22,"Connaissances académiques"),
            new Skill(23,"Cultures"),
            new Skill(24,"Langages"),
            new Skill(25,"Lire et écrire"),
            new Skill(26,"Mécanismes"),
            new Skill(27,"Médecine"),
            new Skill(28,"Navigation"),
            new Skill(29,"Pièges"),
            new Skill(30,"Bricolage"),
            new Skill(31,"Camouflage"),
            new Skill(32,"Connaissance de la rue"),
            new Skill(33,"Débrouillardise"),
            new Skill(34,"Déguisement"),
            new Skill(35,"Enquête"),
            new Skill(36,"Jeux"),
            new Skill(37,"Pister"),
            new Skill(38,"Pratiques artistiques"),
            new Skill(39,"Rechercher"),
            new Skill(40,"Survie"),
            new Skill(41,"Bluff"),
            new Skill(42,"Charme"),
            new Skill(43,"Commander"),
            new Skill(44,"Courage"),
            new Skill(45,"Dressage"),
            new Skill(46,"Intimidation"),
            new Skill(47,"Persuasion"),
            new Skill(48,"Missiles"),
    		new Skill(49,"Business"),
    		new Skill(50,"Culture générale"),
    		new Skill(51,"Démolition"),
    		new Skill(52,"Falsification"),
    		new Skill(53,"Ingénierie"),
            new Skill(54,"Volonté")
    );

    @PostConstruct
    public void init() {
    	skills.addAll(skillsInit);
	}
	
	@Override
	public List<Skill> getSkills() {
		return skills;
	}

	@Override
	public Skill getSkillById(int id) {
		return skills.stream().filter(c -> c.getId()==id).findFirst().orElse(null);
	}

	@Override
	public void createSkill(Skill skill) {
		skill.setId(indexSkill);
		skills.add(skill);
		indexSkill++;
	}

	@Override
	public void deleteSkillById(int id) {
		skills.remove(id);
	}

}
