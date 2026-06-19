document.addEventListener("DOMContentLoaded", () => {

    const modal = document.getElementById("myModal");
    const scoreSpan = document.getElementById("diceResult");
    const closeBtn = document.querySelector(".close");

    document.querySelectorAll(".btn-roll").forEach(button => {

        button.addEventListener("click", () => {

            const pipContainer = button.closest(".pip-a-card");
            const diceText = pipContainer.querySelector("span").innerText.trim();

            const result = rollDiceExpression(diceText);

            scoreSpan.textContent = result;

            // Ouvre la modal
            modal.classList.add("open");
        });
    });

    // Fermeture via le X
    closeBtn?.addEventListener("click", () => {
        modal.classList.remove("open");
    });

    // Fermeture en cliquant sur le fond
    modal?.addEventListener("click", (event) => {
        if (event.target === modal) {
            modal.classList.remove("open");
        }
    });
});

/**
 * Convertit une expression du type :
 * 3D
 * 3D+1
 * 4D+2
 */
function rollDiceExpression(expression) {

    const match = expression.match(/(\d+)D(?:\+(\d+))?/i);

    if (!match) {
        return 0;
    }

    const diceCount = parseInt(match[1], 10);
    const bonus = parseInt(match[2] || 0, 10);

    let total = bonus;

    for (let i = 0; i < diceCount; i++) {
        total += rollD6();
    }

    return total;
}

function rollD6() {
    return Math.floor(Math.random() * 6) + 1;
}