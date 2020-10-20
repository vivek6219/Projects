import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class WeatherServiceService {
  key = '7d726039e19ad1466a232c9d358e7d4d';
  url: any;
constructor(private http: HttpClient) {
  this.url = 'https://samples.openweathermap.org/data/2.5/forecast?q=';
 }
 getWeatherData(city, country){
   return this.http.get(this.url + city + ',' + country + '&APPID=' + this.key);
 }

}
