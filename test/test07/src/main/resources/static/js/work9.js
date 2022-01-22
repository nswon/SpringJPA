const backing = document.querySelector('div');
const octagon = document.querySelector('.animate');

const player = octagon.animate({
    clipPath: [`polygon(
      30% 0%, 70% 0%, 70% 0%,
      100% 30%, 100% 70%,
      70% 100%, 30% 100%,
      0% 70%, 0% 30%
    )`, `polygon(
      30% 0%, 70% 0%, 50% 50%,
      100% 30%, 100% 70%,
      70% 100%, 30% 100%,
      0% 70%, 0% 30%
    )`, `polygon(
      30% 0%, 70% 0%, 50% 50%,
      50% 50%, 100% 70%,
      70% 100%, 30% 100%,
      0% 70%, 0% 30%
    )`, `polygon(
      30% 0%, 70% 0%, 50% 50%,
      50% 50%, 50% 50%,
      70% 100%, 30% 100%,
      0% 70%, 0% 30%
    )`, `polygon(
      30% 0%, 70% 0%, 50% 50%,
      50% 50%, 50% 50%,
      50% 50%, 30% 100%,
      0% 70%, 0% 30%
    )`, `polygon(
      30% 0%, 70% 0%, 50% 50%,
      50% 50%, 50% 50%,
      50% 50%, 50% 50%,
      0% 70%, 0% 30%
    )`, `polygon(
      30% 0%, 70% 0%, 50% 50%,
      50% 50%, 50% 50%,
      50% 50%, 50% 50%,
      50% 50%, 0% 30%
    )`, `polygon(
      30% 0%, 70% 0%, 50% 50%,
      50% 50%, 50% 50%,
      50% 50%, 50% 50%,
      50% 50%, 50% 50%
    )`, `polygon(
      50% 50%, 70% 0%, 50% 50%,
      50% 50%, 50% 50%,
      50% 50%, 50% 50%,
      50% 50%, 50% 50%
    )`,
    ]
}, {
    duration: 2000,
    easing: 'steps(9)',
    //easing: 'ease-in',
    iterations: 1,
    fill: 'both',
    endDelay: 1000
});


player.onfinish = () => {
    const computed = getComputedStyle(backing);
    const hue = computed.getPropertyValue('--hue');
    const url = computed.getPropertyValue('--img');
    const url2 = getComputedStyle(octagon).getPropertyValue('--img');
    octagon.style.setProperty('--hue', hue);
    backing.style.setProperty('--hue', parseFloat(hue.trim()) + 100);
    octagon.style.setProperty('--img', url);
    backing.style.setProperty('--img', url2);
    player.play();
}