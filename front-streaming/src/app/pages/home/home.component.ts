import { Component, OnInit } from '@angular/core';
import { MovieApiService } from '../../services/movie-api.service';
import { log } from 'console';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit{

  isLoading: boolean= true;

  bannerData: Array<any>= [];
  trendingData: Array<any>= [];
  actionMovie: Array<any>= [];
  adventureMovie: Array<any>= [];
  animationMovie: Array<any>= [];
  comedyMovie: Array<any>= [];
  documentaryMovie: Array<any>= [];
  scienceFictionMovie: Array<any>= [];
  thrillerMovie: Array<any>= [];

  movieGenres: Array<string>= [
    'trendingData',
    'actionMovie',
    'adventureMovie',
    'animationMovie',
    'comedyMovie',
    'documentaryMovie',
    'scienceFictionMovie',
    'thrillerMovie'
  ]

  constructor(private movieService: MovieApiService) {}

  ngOnInit(): void {
    console.log("location general"+window.location.origin);
    
    this.bannerApi();
    this.trendigApi();
    this.getActionMovie();
    this.getAdventureMovie();
    this.getAnimationMovie();
    this.getComedyMovie();
    this.getScienceFictionMovie();
    this.getThrillerMovie();
    this.getDocumentaryMovie();
  }

  bannerApi() { 
    this.movieService.bannerApiData().subscribe({ 
      next: data=> {
        this.bannerData= data.results;
        console.table(this.bannerData);
      },
      error: err=> {
        console.log(err);
      }
    })
  }

  trendigApi() {
    this.movieService.trendingMovieApiData().subscribe({
      next: data=>  {
        this.trendingData= data.results;
        console.table(data);
      }
    })
  }

  getActionMovie() {
    this.movieService.fetchActionMovie().subscribe({
      next: data=> {
        console.log('action movie: ', data);
        this.actionMovie= data.results;
      }
    })
  }

  getAdventureMovie() {
    this.movieService.fetchAdventureMovie().subscribe({
      next: data=> {
        console.table(data);
        this.adventureMovie= data.results;
      }
    })
  }

  getComedyMovie() {
    this.movieService.fetchComedyMovie().subscribe({
      next: data=> {
        console.table(data);
        this.comedyMovie= data.results;
      }
    })
  }

  getAnimationMovie() {
    this.movieService.fetchAnimationMovie().subscribe({
      next: data=> {
        console.table(data);
        this.animationMovie= data.results;
      }
    })
  }

  getDocumentaryMovie() {
    this.movieService.fetchDocumentaryMovie().subscribe({
      next: data=> {
        console.table(data);
        this.documentaryMovie= data.results;
      }
    })
  }

  getScienceFictionMovie() {
    this.movieService.fetchScienceFictionMovie().subscribe({
      next: data=> {
        console.table(data);
        this.scienceFictionMovie= data.results;
      }
    })
  }

  getThrillerMovie() {
    this.movieService.fetchThrillerMovie().subscribe({
      next: data=> {
        console.table(data);
        this.thrillerMovie= data.results;
      }
    })
  }

}
