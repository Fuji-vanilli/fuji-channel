import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MovieApiService } from '../../services/movie-api.service';

@Component({
  selector: 'app-movie-details',
  templateUrl: './movie-details.component.html',
  styleUrls: ['./movie-details.component.scss']
})
export class MovieDetailsComponent implements OnInit{

  movieDetails: any;
  movieVideo: any;
  movieCast: any;

  movieId: any;
Math: any;

  constructor(private movieService: MovieApiService,
              private activateRoute: ActivatedRoute,
              private route: Router) {}

  ngOnInit(): void {
    this.movieId= this.activateRoute.snapshot.params['id'];
    this.getMovie(this.movieId);
    this.getVideo(this.movieId);
    this.getMovieCast(this.movieId);
  }

  getMovie(movieId: string) {
    this.movieService.getMovieDetails(movieId).subscribe({
      next: data=> {        
        this.movieDetails= data;
        console.log(this.movieDetails);
      },
      error: err=> {
        console.log(err);
        
      }
    })
  }

  getVideo(movieId: string) {
    this.movieService.getMovideVideo(movieId).subscribe({
      next: data=> {
        console.log('videoMovie', data);
        data.results.forEach((element: any)=> {
          if (element.type== 'Trailer') {
            this.movieVideo= element.key;
          }
        })
      }
    })
  }

  getMovieCast(movieId: string) {
    this.movieService.getMovieCast(movieId).subscribe({
      next: data=> {
        console.log('movieCast', data); 
        this.movieCast= data.cast; 
      }
    })
  }

  login() {
    this.route.navigateByUrl('/login');
  }
}
