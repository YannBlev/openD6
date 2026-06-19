package bzh.amzerin.openD6.dal.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import bzh.amzerin.openD6.bo.Attribute;
import bzh.amzerin.openD6.bo.Skill;
import bzh.amzerin.openD6.bo.Universe;
import bzh.amzerin.openD6.dal.UniverseDao;
import jakarta.annotation.PostConstruct;

@Repository
@Profile("mock")
public class UniverseDaoMock implements UniverseDao {

    private static final List<Universe> universes = new ArrayList<>();
    private static final List<Skill> skills= new ArrayList<>();
    private static final List<Attribute> attributes= new ArrayList<>();
    private static int indexUniverse = 1;

    /** ******************* **
     *      SKILLS FANTASY   *
     ** ******************* **/
    
    private final List<Skill> agiliteFantasy = List.of(
	        new Skill(1,"Acrobatie"),
	        new Skill(2,"Armes blanches"),
	        new Skill(3,"Contorsion"),
	        new Skill(4,"Discretion"),
	        new Skill(5,"Equitation"),
	        new Skill(6,"Escalade"),
	        new Skill(7,"Esquive"),
	        new Skill(8,"Lutte"),
	        new Skill(9,"Saut"),
	        new Skill(10,"Vol")
    );

    private final List<Skill> coordinationFantasy = List.of(
            new Skill(11,"Chariots"),
            new Skill(12,"Crochetage"),
            new Skill(13,"Lancer"),
            new Skill(14,"Pilotage"),
            new Skill(15,"Prestidigidation"),
            new Skill(16,"Tir")
	);

    private final List<Skill> vigueurFantasy = List.of(
            new Skill(17,"Course"),
            new Skill(18,"Nage"),
            new Skill(19,"Puissance"),
            new Skill(20,"Résistance")
	);
    
    private final List<Skill> savoirFantasy = List.of(
            new Skill(21,"Commerce"),
            new Skill(22,"Connaissances académiques"),
            new Skill(23,"Cultures"),
            new Skill(24,"Langages"),
            new Skill(25,"Lire et écrire"),
            new Skill(26,"Mécanismes"),
            new Skill(27,"Médecine"),
            new Skill(28,"Navigation"),
            new Skill(29,"Pièges")
	);
    
    private final List<Skill> perceptionFantasy = List.of(
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
            new Skill(40,"Survie")
	);
    
    private final List<Skill> charismeFantasy = List.of(
            new Skill(41,"Bluff"),
            new Skill(42,"Charme"),
            new Skill(43,"Commander"),
            new Skill(44,"Courage"),
            new Skill(45,"Dressage"),
            new Skill(46,"Intimidation"),
            new Skill(47,"Persuasion")
	);
    
    /** ********************** **
     *      SKILLS ADVENTURES   *
     ** ********************** **/
    
    private final List<Skill> agiliteAdventures = agiliteFantasy;
    
    private final List<Skill> coordinationAdventures = List.of(
            new Skill(48,"Missiles"),
            new Skill(12,"Crochetage"),
            new Skill(13,"Lancer"),
            new Skill(14,"Pilotage"),
            new Skill(15,"Prestidigidation"),
            new Skill(16,"Tir")
	);
    
    private final List<Skill> vigueurAdventures = vigueurFantasy;
    
    private final List<Skill> savoirAdventures = List.of(
    		new Skill(49,"Business"),
    		new Skill(50,"Culture générale"),
    		new Skill(51,"Démolition"),
    		new Skill(52,"Falsification"),
    		new Skill(53,"Ingénierie"),
    		new Skill(54,"Langages"),
            new Skill(27,"Médecine"),
            new Skill(28,"Navigation"),
            new Skill(55,"Sécurité")
	);
    
    private final List<Skill> perceptionAdventures = List.of(
            new Skill(30,"Bricolage"),
            new Skill(31,"Camouflage"),
            new Skill(32,"Connaissance de la rue"),
            new Skill(33,"Débrouillardise"),
            new Skill(35,"Enquête"),
            new Skill(36,"Jeux"),
            new Skill(37,"Pister"),
            new Skill(38,"Pratiques artistiques"),
            new Skill(39,"Rechercher"),
            new Skill(40,"Survie")
	);
    
    private final List<Skill> charismeAdventures = List.of(
            new Skill(42,"Charme"),
            new Skill(43,"Commander"),
            new Skill(34,"Déguisement"),
            new Skill(44,"Courage"),
            new Skill(45,"Dressage"),
            new Skill(46,"Intimidation"),
            new Skill(47,"Persuasion"),
            new Skill(56,"Volonté")
	);
    
    /** ******************* **
     *  ATTRIBUTES FANTASY   *
     ** ******************* **/
    
    private final List<Attribute> fantasyAttributes = List.of(
        new Attribute(1, "AGILITE", agiliteFantasy),
        new Attribute(2, "COORDINATION", coordinationFantasy),
        new Attribute(3, "VIGUEUR", vigueurFantasy),
        new Attribute(4, "SAVOIR", savoirFantasy),
        new Attribute(5, "PERCEPTION", perceptionFantasy),
        new Attribute(6, "CHARISME", charismeFantasy)
	);

    /** ******************* **
     *  ATTRIBUTES ADVENTURES   *
     ** ******************* **/
    
    private final List<Attribute> adventuresAttributes = List.of(
            new Attribute(7, "AGILITE", agiliteAdventures),
            new Attribute(8, "COORDINATION", coordinationAdventures),
            new Attribute(9, "VIGUEUR", vigueurAdventures),
            new Attribute(10, "SAVOIR", savoirAdventures),
            new Attribute(11, "PERCEPTION", perceptionAdventures),
            new Attribute(12, "CHARISME", charismeAdventures)
	);
    
    @PostConstruct
    public void init() {
        Universe fantasy = new Universe();
        fantasy.setId(indexUniverse++);
        fantasy.setName("Fantasy");
        fantasy.setAttributes(fantasyAttributes);
        
        Universe adventures = new Universe();
        adventures.setId(indexUniverse++);
        adventures.setName("Adventures");
        adventures.setAttributes(adventuresAttributes);

        universes.add(fantasy);
        universes.add(adventures);

        attributes.addAll(fantasyAttributes);
        attributes.addAll(adventuresAttributes);
	}

    @Override
    public List<Universe> getUniverses() {
        return universes;
    }

    @Override
    public Universe getUniverseById(int id) {
        return universes.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void createUniverse(Universe universe) {
        universe.setId(indexUniverse++);
        universes.add(universe);
    }

    @Override
    public void deleteUniverseById(int id) {
        universes.remove(id);
    }

    /** ******************* **
     *  ATTRIBUTES GETTERS   *
     ** ******************* **/
    
    public List<Attribute> getAttributes() {
    	return attributes;
    }
    
    public Attribute getAttributeById(int id) {
    	return attributes.get(id);
    }
    
    public List<Attribute> getAttributesByIdUniverse(int id) {
    	return universes.get(id).getAttributes();
    }

    /** ******************* **
     *     SKILLS GETTERS    *
     ** ******************* **/
    
    public List<Skill> getSkills() {
    	return skills;
    }
    
    public Skill getSkillById(int id) {
    	return skills.get(id);
    }
    
    public List<Skill> getSkillsByIdAttributes(int id) {
    	return attributes.get(id).getSkills();
    }
    
}
