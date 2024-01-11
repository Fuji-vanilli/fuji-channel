import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Pagination } from 'src/app/models/pagination';
import { MovieApiService } from 'src/app/services/movie-api.service';


@Component({
  selector: 'app-card-movie',
  templateUrl: './card-movie.component.html',
  styleUrls: ['./card-movie.component.scss']
})
export class CardMovieComponent implements OnInit {

  categoriesMovie: Array<any>= [];
  categoryName: string= '';
  page: number= 1;

  totalItems: number= 1;
  pagination: any;
    
  constructor(private movieService: MovieApiService,
              private routeActivate: ActivatedRoute) {
              }

  ngOnInit(): void {
    this.categoryName= this.routeActivate.snapshot.params['category'];
    this.getMovieByCategory(this.page);    
  }

  getMovieByCategory(page: number) {
    this.movieService.fetchActionMovie(page).subscribe({ 
      next: data=> {
        console.log('action movie', data);
        this.categoriesMovie= data.results;  
        this.totalItems= data.total_pages;  
      }
    })
  }
  
  pageChange(pageEvent: any) {
    this.page= pageEvent.page;
    this.getMovieByCategory(pageEvent.page);
  }
  
  

}
