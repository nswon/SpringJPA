const panels = document.querySelectorAll("main > div");

panels.forEach((panel, i) => {
    panel.style.setProperty("--ry", `${i / panels.length}turn`);
    panel.style.setProperty("--hue", i * 20 - 17);
    panel.style.setProperty("--s", (i * 0.5) / panels.length + 0.5);

    panel.querySelector("div").animate(
        {
            transform: ["rotateY(var(--ry))", "rotateY(calc(var(--ry) + 1turn))"]
        },
        {
            id: `animation-${i}`,
            duration: 14000 + Math.random() * 8000,
            iterations: Infinity,
            delay: -(Math.random() * 4000) - 12000,
            direction: i % 2 === 0 ? "normal" : "reverse"
        }
    );
});

if (matchMedia("(prefers-reduced-motion: reduce)").matches) {
    document
        .getAnimations()
        //.filter((animation) => animation.id)
        .forEach((animation) => {
            animation.pause();
        });
}