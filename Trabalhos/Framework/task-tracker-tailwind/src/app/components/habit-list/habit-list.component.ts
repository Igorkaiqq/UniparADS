import { Component, OnInit } from '@angular/core';
import { HabitoService } from '../../services/habito.service';
import {DatePipe} from "@angular/common";

@Component({
  selector: 'app-habit-list',
  templateUrl: './habit-list.component.html',
  standalone: true,
  imports: [
    DatePipe
  ],
  styleUrls: ['./habit-list.component.css']
})
export class HabitListComponent implements OnInit {
  habitos: any[] = [];

  constructor(private habitoService: HabitoService) { }

  ngOnInit(): void {
    this.habitoService.getHabitos().subscribe(data => {
      this.habitos = data;
    });
  }
}
