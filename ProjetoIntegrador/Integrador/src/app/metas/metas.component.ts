import { Component } from '@angular/core';

@Component({
  selector: 'app-dashboard',
  templateUrl: './metas.component.html',
  styleUrls: ['./metas.component.css']
})
export class MetasComponent {

  createGoal() {
    console.log('Create Goal');
  }

  editGoal() {
    console.log('Edit Goal');
  }

  deleteGoal() {
    console.log('Delete Goal');
  }
}