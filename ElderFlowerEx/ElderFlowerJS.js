var greeting = "Hello";
var name ="John";
var message = ', please check your order:';
var welcome = greeting+name+message;

var sign = "Montgemery House"
var tiles = sign.length;
var subTotal = tiles*5;
var shipping =7;
var grandTotal = subTotal + shipping;

var ele = document.getElementById('greeting');
ele.textContent= welcome;

var eleSign = document.getElementById('userSign');
ele.textContent=sign;

var eleTiles = document.getElementById('subTotal');
ele.textContent='$' +subTotal;

var eleShipping = document.getElementById('shipping');
ele.textContent ='$' +shipping;


var eleGrandTotal = document.getElementById('grandTotal');
ele.textContent= '$' +grandTotal;