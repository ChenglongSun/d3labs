var colors = generateRandomColor(6);
var squares = document.querySelectorAll(".square");
var pickedColor = pickColor();
var colorDisplay = document.getElementById("colorDisplay");
var messageDisplay = document.querySelector("#message");
var h1 = document.querySelector("h1");
var resetButton = document.querySelector("#reset");
var easyButton = document.querySelector("#ezbtn");
var hardButton = document.querySelector("#hdbtn");

easyButton.addEventListener("click", function(){
	easyButton.classList.add("selected");
	hardButton.classList.remove("selected");
})

hardButton.addEventListener("click", function(){
	hardButton.classList.add("selected");
	easyButton.classList.remove("selected");
})

resetButton.addEventListener("click", function(){
	colors = generateRandomColor(6);
	pickedColor = pickColor();
	colorDisplay.textContent = pickedColor;
	for (var i = 0; i < colors.length; i++) {
		squares[i].style.background = colors[i];
	}

})


colorDisplay.textContent = pickedColor;


for (var i = 0; i < squares.length; i++) {

	squares[i].style.background = colors[i];
	//listener
	squares[i].addEventListener("click", function() {
		if (this.style.background == pickedColor) {
			messageDisplay.textContent = "Correct!";
			resetButton.textContent = "play again";
			changeColors(pickedColor);
			h1.style.background = pickedColor;
		} else {
			this.style.background = "#232323";
			messageDisplay.textContent = "Try Again";
		}
	})
}

function changeColors(color) {
	for (var i = 0; i < colors.length; i++) {
		squares[i].style.background = color;
	}
}

function pickColor(){
	var random = Math.floor(Math.random() * colors.length);
	return colors[random];
}


function generateRandomColor(num) {
	var arr = [];
	for (var i = 0; i < num; i++) {
		arr.push(randomColor());
	}
	return arr;
}

function randomColor(){
	var r = Math.floor(Math.random() * 256);
	var g = Math.floor(Math.random() * 256);
	var b = Math.floor(Math.random() * 256);
	return "rgb(" + r + ", " + g + ", " + b + ")";
}







