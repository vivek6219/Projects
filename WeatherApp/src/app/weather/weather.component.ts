import { WeatherServiceService } from './weatherService.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-weather',
  templateUrl: './weather.component.html',
  styleUrls: ['./weather.component.css']
})
export class WeatherComponent implements OnInit {


  weatherData: any;
  constructor(private weatherService: WeatherServiceService) { 

  }

  passInLocations ={
    city: 'Columbus',
    country : 'US',
  }
  ngOnInit(): any {
    return this.weatherService.getWeatherData(
      this.passInLocations.city, this.passInLocations.country).
      subscribe((data) =>{console.log(data)});
  }

}
