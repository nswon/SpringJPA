const circle = document.querySelector(".circle");

document.addEventListener("mousemove", (e) => {
    const mouseX = e.clientX;
    const mouseY = e.clientY;
    circle.style.left = mouseX + 'px';
    circle.style.top = mouseY + 'px';
});

var bg = document.getElementById("bg");

setInterval(function(){
    var color = Math.random()*0xffffff;
    color = parseInt(color);
    color = color.toString(16);

    bg.style.background = "#" + color;

},1000);
