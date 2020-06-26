import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  //typescript
  clickCounter: number = 0;
  name: string ='';
  test: string = name;
  constructor() { }

  ngOnInit(): void {
  }

  countClick(){
    this.clickCounter+=1;
  }

}
