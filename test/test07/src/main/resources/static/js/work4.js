var colors = [
    '#F2B705',
    '#F25C05',
    '#0388A6',
    '#0E5929',
    '#F272A1',
]

var container = document.getElementById('container');
var text = document.getElementById('value');
var color = document.getElementById('color');

container.onwheel = changeBgColor;

var colorIndex = 0;
var scrollValue = 0;
var dateNow = Date.now();

function changeBgColor(e) {
    scrollValue += e.deltaY * 0.01;
    text.textContent = Math.floor(scrollValue);

    timePassed = Date.now() - dateNow;
    if (scrollValue > 10 && timePassed > 500) {
        dateNow = Date.now();
        colorIndex += 1;
        if (colorIndex > colors.length-1) colorIndex = 0;
        color.textContent = colors[colorIndex];
        container.style.backgroundColor = colors[colorIndex];
        scrollValue = 0;
    }

    if (scrollValue < -10 && timePassed > 500) {
        dateNow = Date.now();
        colorIndex -= 1;
        if (colorIndex < 0) colorIndex = colors.length-1;
        color.textContent = colors[colorIndex];
        container.style.backgroundColor = colors[colorIndex];
        scrollValue = 0;
    }
    e.preventDefault(); // disable the actual scrolling
}