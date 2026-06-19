package bzh.amzerin.openD6.dal.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import bzh.amzerin.openD6.bo.Attribute;
import bzh.amzerin.openD6.bo.Skill;
import bzh.amzerin.openD6.dal.AttributeDao;
import jakarta.annotation.PostConstruct;

@Repository
@Profile("mock")
public class AttributeDaoMock implements AttributeDao{

	private static List<Attribute> attributes = new ArrayList<>();
    private static final List<Skill> skills= new ArrayList<>();
	private static int indexAttribute = 0;

	SkillDaoMock skillDaoMock;
	
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
        attributes.addAll(fantasyAttributes);
        attributes.addAll(adventuresAttributes);
	}
    
	public AttributeDaoMock() {
		indexAttribute = attributes.size()+1;
	}
	
	@Override
	public List<Attribute> getAttributes() {
		return attributes;
	}

	@Override
	public Attribute getAttributeById(int id) {
		return attributes.stream().filter(a -> a.getId()==id).findFirst().orElse(null);
	}

	@Override
	public void createAttribute(Attribute attribute) {
		attribute.setId(indexAttribute);
		attributes.add(attribute);
		indexAttribute++;
	}

	@Override
	public void deleteAttributeById(int id) {
		attributes.remove(id);	
	}

}
