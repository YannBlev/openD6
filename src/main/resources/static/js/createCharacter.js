/**
 * ============================================================================
 * createCharacter.js
 * ----------------------------------------------------------------------------
 * Gestion dynamique du formulaire de création de personnage OpenD6.
 *
 * Fonctionnalités :
 * - Affichage automatique des valeurs en dés (D6)
 * - Mise à jour des compétences selon l’attribut associé
 * - Calcul du stock restant de points (pips)
 * - Synchronisation temps réel lors des changements utilisateur
 * ============================================================================
 */

/**
 * ---------------------------------------------------------------------------
 * INITIALISATION AU CHARGEMENT DE LA PAGE
 * ---------------------------------------------------------------------------
 */
document.addEventListener("DOMContentLoaded", () => {

    // Récupération de toutes les cartes d'attributs
    const attributeCards = document.querySelectorAll(".a-card");

    attributeCards.forEach(card => {

        // Slider principal de l’attribut
        const attributeRange =
            card.querySelector(".libelle-a-card input[type='range']");

        /**
         * Mise à jour de l’attribut lorsque sa valeur change
         */
        attributeRange.addEventListener("input", () => {

            updateAttribute(card);
            updateStocks();
        });

        /**
         * Gestion des sliders de compétences
         */
        const skillCards = card.querySelectorAll(".skill-a-card");

        skillCards.forEach(skill => {

            const skillRange =
                skill.querySelector("input[type='range']");

            /**
             * Mise à jour d’une compétence lors d’un changement
             */
            skillRange.addEventListener("input", () => {

                updateSkill(card, skill);
                updateStocks();
            });
        });

        /**
         * Initialisation visuelle de l’attribut
         */
        updateAttribute(card);
    });

    /**
     * Initialisation du stock global
     */
    updateStocks();
});

/**
 * ---------------------------------------------------------------------------
 * MET À JOUR L’AFFICHAGE D’UN ATTRIBUT
 * ---------------------------------------------------------------------------
 *
 * @param {HTMLElement} card Carte contenant l’attribut
 */
function updateAttribute(card) {

    // Slider de l’attribut
    const attributeRange =
        card.querySelector(".libelle-a-card input[type='range']");

    // Valeur actuelle de l’attribut
    const attributeValue =
        parseInt(attributeRange.value) || 0;

    /**
     * Le span affichant la valeur en dés est situé
     * dans le même conteneur que le slider.
     */
    const diceDisplay =
        attributeRange.parentElement.querySelector("span");

    // Mise à jour de l’affichage au format D6
    if (diceDisplay) {

        diceDisplay.innerText =
            convertPipToDice(attributeValue);
    }

    /**
     * Toutes les compétences dépendantes doivent être recalculées
     * lorsque l’attribut change.
     */
    const skills =
        card.querySelectorAll(".skill-a-card");

    skills.forEach(skill => {

        updateSkill(card, skill);
    });
}

/**
 * ---------------------------------------------------------------------------
 * MET À JOUR L’AFFICHAGE D’UNE COMPÉTENCE
 * ---------------------------------------------------------------------------
 *
 * Une compétence = valeur de l’attribut + bonus compétence
 *
 * @param {HTMLElement} card  Carte de l’attribut
 * @param {HTMLElement} skill Carte de la compétence
 */
function updateSkill(card, skill) {

    // Valeur de l’attribut parent
    const attributeRange =
        card.querySelector(".libelle-a-card input[type='range']");

    const attributeValue =
        parseInt(attributeRange.value) || 0;

    // Valeur propre à la compétence
    const skillRange =
        skill.querySelector("input[type='range']");

    const skillValue =
        parseInt(skillRange.value) || 0;

    /**
     * Total utilisé pour calculer le niveau final
     * de la compétence.
     */
    const totalPips =
        attributeValue + skillValue;

    // Span d’affichage de la compétence
    const diceDisplay =
        skillRange.parentElement.querySelector("span");

    // Mise à jour du rendu visuel
    if (diceDisplay) {

        diceDisplay.innerText =
            convertPipToDice(totalPips);
    }
}

/**
 * ---------------------------------------------------------------------------
 * CONVERTIT DES PIPS EN FORMAT D6
 * ---------------------------------------------------------------------------
 *
 * Exemple :
 * 3  -> 1D
 * 4  -> 1D+1
 * 5  -> 1D+2
 * 6  -> 2D
 *
 * @param {number} pip Nombre de pips
 * @returns {string} Valeur formatée
 */
function convertPipToDice(pip) {

    // Nombre entier de dés
    const dice =
        Math.floor(pip / 3);

    // Reste des pips
    const remainder =
        pip % 3;

    // Aucun reste
    if (remainder === 0) {

        return `${dice}D`;
    }

    // Avec bonus de pips
    return `${dice}D+${remainder}`;
}

/**
 * ---------------------------------------------------------------------------
 * MET À JOUR LE STOCK RESTANT DE PIPS
 * ---------------------------------------------------------------------------
 *
 * Règles :
 * - Attributs :
 *      Base gratuite = 3 pips par attribut
 *      Stock total = 54
 *
 * - Compétences :
 *      Stock total = 21
 */
function updateStocks() {

    // Stock initial des attributs
    let attributeStock = 54;

    // Stock initial des compétences
    let skillStock = 21;

    /**
     * Calcul des points dépensés dans les attributs
     */
    const attributeInputs =
        document.querySelectorAll(
            ".libelle-a-card input[type='range']"
        );

    attributeInputs.forEach(input => {

        const currentValue =
            parseInt(input.value) || 0;

        /**
         * Les 3 premiers pips sont gratuits.
         */
        attributeStock -= (currentValue - 3);
    });

    /**
     * Calcul des points dépensés dans les compétences
     */
    const skillInputs =
        document.querySelectorAll(
            ".skill-a-card input[type='range']"
        );

    skillInputs.forEach(input => {

        const currentValue =
            parseInt(input.value) || 0;

        skillStock -= currentValue;
    });

    /**
     * Mise à jour de l’affichage HTML
     */
    document.getElementById("pipAttributeStock").innerText =
        attributeStock;

    document.getElementById("pipSkillStock").innerText =
        skillStock;
}