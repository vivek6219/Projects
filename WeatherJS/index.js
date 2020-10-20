const iconElement = document.querySelector(".weather-icon");
const tempElement = document.querySelector(".temperature-value p");
const descElement = document.querySelector(".temperature-description p");
const locationElement = document.querySelector(".location p")
const notificationElement = document.querySelector(".notification");

const weather = {

};

weather.temperature = {
    unit: "celsius"
}

const KELVIN = 273;
const apiKey="7d726039e19ad1466a232c9d358e7d4d";


if('geolocation' in navigator){
    navigator.geolocation.getCurrentPosition(setPosition, showError);
}
else{
    notificationElement.style.display = "block";
    notificationElement.innerHTML = "<p>Browser doesn't support geolocation</p>";
}

function setPosition(position){
    let latitude = position.coords.latitude;
    let longitude = position.coords.longitude;
    getWeather(latitude, longitude);
}

function showError(error){
    
    notificationElement.style.display = "block".innerHTML="<p>error</p>";
    
}


function getWeather(latitude,longitude){
    let api = 'api.openweathermap.org/data/2.5/weather?lat='+latitude+ '&lon='+longitude + '&appid='+apiKey;
  
    fetch(api).then(function(respons){
        let data = response.json();
        return data;
    }).then(function(data){
        weather.temperature.value=Math.floor(data.main.temp-KELVIN);
        weather.description=data.weather[0].icon;
        weather.iconId = data.weather[0].icon;
        weather.city = data.name;
        weather.country = data.sys.country;
    }).then(function(){
        displayWeather();
    });
    console.log(latitude,longitude);
    console.log(api);
}

function displayWeather(){
    iconElement.innerHTML = "<img src ="+ "icons/" +weather.iconId+".png/>";
    tempElement.innerHTML= weather.temperature.value+ "°" +"<span>C</span>"
    descElement.innerHTML=weather.description;
    locationElement.innerHTML = weather.city, weather.country;
}