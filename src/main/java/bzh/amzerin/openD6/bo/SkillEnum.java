package bzh.amzerin.openD6.bo;

public enum SkillEnum {

    ACROBATIE(1,"Acrobatie"),
    ARMES_BLANCHES(2,"Armes blanches"),
    CONTORSION(3,"Contorsion"),
    DISCRETION(4,"Discretion"),
    EQUITATION(5,"Equitation"),
    ESCALADE(6,"Escalade"),
    ESQUIVE(7,"Esquive"),
    LUTTE(8,"Lutte"),
    SAUT(9,"Saut"),
    VOL(10,"Vol"),
    CHARIOTS(11,"Chariots"),
    CROCHETAGE(12,"Crochetage"),
    LANCER(13,"Lancer"),
    PILOTAGE(14,"Pilotage"),
    PRESTIDIGIDATION(15,"Prestidigidation"),
    TIR(16,"Tir"),
    COURSE(17,"Course"),
    NAGE(18,"Nage"),
    PUISSANCE(19,"Puissance"),
    RESISTANCE(20,"Résistance"),
    COMMERCE(21,"Commerce"),
    CONNAISSANCES_ACADEMIQUES(22,"Connaissances académiques"),
    CULTURES(23,"Cultures"),
    LANGAGES(24,"Langages"),
    LIRE_ET_ECRIRE(25,"Lire et écrire"),
    MECANISMES(26,"Mécanismes"),
    MEDECINE(27,"Médecine"),
    NAVIGATION(28,"Navigation"),
    PIEGES(29,"Pièges"),
    BRICOLAGE(30,"Bricolage"),
    CAMOUFLAGE(31,"Camouflage"),
    CONNAISSANCE_DE_LA_RUE(32,"Connaissance de la rue"),
    DEBROUILLARDISE(33,"Débrouillardise"),
    DEGUISEMENT(34,"Déguisement"),
    ENQUETE(35,"Enquête"),
    JEUX(36,"Jeux"),
    PISTER(37,"Pister"),
    PRATIQUES_ARTISTIQUES(38,"Pratiques artistiques"),
    RECHERCHER(39,"Rechercher"),
    SURVIE(40,"Survie"),
    BLUFF(41,"Bluff"),
    CHARME(42,"Charme"),
    COMMANDER(43,"Commander"),
    COURAGE(44,"Courage"),
    DRESSAGE(45,"Dressage"),
    INTIMIDATION(46,"Intimidation"),
    PERSUASION(47,"Persuasion"),
    MISSILES(48,"Missiles"),
	BUSINESS(49,"Business"),
	CULTURE_GENERALE(50,"Culture générale"),
	DEMOLITION(51,"Démolition"),
	FALSIFICATION(52,"Falsification"),
	INGENIERIE(53,"Ingénierie"),
    VOLONTE(54,"Volonté");
    
    private final int id;
    private final String label;

    SkillEnum(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }
}