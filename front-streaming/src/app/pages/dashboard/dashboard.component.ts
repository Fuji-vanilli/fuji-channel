import { Component, OnInit } from '@angular/core';
import { MovieApiService } from 'src/app/services/movie-api.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit{

  auth: any;

  constructor(private movieService: MovieApiService) {}
  ngOnInit(): void {
    this.getAuth();
  }

  getAuth() {
    this.movieService.getAuth().subscribe({
      next: resp=> {
        this.auth= resp;
        console.table(resp);
      }
    })
  }
}
