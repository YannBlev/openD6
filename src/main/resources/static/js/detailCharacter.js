document.addEventListener("DOMContentLoaded", () => {

    document.querySelectorAll(".a-card").forEach(card => {

        updateAttribute(card);

    });

});

function updateAttribute(card) {

    // récupère la valeur du pip attribute
    const attrPipSpan = card.querySelector(".libelle-a-card .pip-a-card span");

    if (!attrPipSpan) return;

    const attrValue = parseInt(attrPipSpan.innerText) || 0;

    // remplace la valeur brute par le format D6
    attrPipSpan.innerText = convertPipToDice(attrValue);

    // update skills
    card.querySelectorAll(".skill-a-card").forEach(skill => {
        updateSkill(attrValue, skill);
    });
}

function updateSkill(attrValue, skill) {

    const skillPipSpan = skill.querySelector(".pip-a-card span");

    if (!skillPipSpan) return;

    const skillValue = parseInt(skillPipSpan.innerText) || 0;

    const total = attrValue + skillValue;

    // affiche le total en dés
    skillPipSpan.innerText = convertPipToDice(total);
}

function convertPipToDice(pip) {

    const dice = Math.floor(pip / 3);
    const rest = pip % 3;

    return rest === 0
        ? `${dice}D`
        : `${dice}D+${rest}`;
}