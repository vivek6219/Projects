import { HeroService } from './../hero.service';
import { Component, OnInit } from '@angular/core';
import {Hero} from '../hero'

@Component({
  selector: 'app-heroes',
  templateUrl: './heroes.component.html',
  styleUrls: ['./heroes.component.css']
})
export class HeroesComponent implements OnInit {

  heroes: Hero[];

  constructor(private heroService: HeroService) { }
  selectedHero: Hero;
  ngOnInit(): void {
    this.getHeroes();
  }


  onSelect(hero: Hero): void{
    this.selectedHero=hero;
  }
  getHeroes():void{
    this.heroes=this.heroService.getHeroes();
  }
}
