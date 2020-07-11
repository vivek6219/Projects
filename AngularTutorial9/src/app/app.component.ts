import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  nameTxt="VIVI"
  title = 'AngularTutorial9';
  arrayData =[10,12,30,8];

  showMe = true;

  color ="yellow";

  fruit=['apple', 'banana', 'pineapple', 'guava', 'watermelon'];

  obj={
    name:'Dave',
    age: 25
  }

  testFunction(a){
    alert(a);
  }

  getVal(item){
    console.log(item.target.value);
  }

  getTextBoxValue(item){
    alert(item.value);
  }

  onSubmit(data){
    console.warn(data)
  }
}
