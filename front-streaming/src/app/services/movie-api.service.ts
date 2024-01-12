import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class MovieApiService {

  constructor(private http: HttpClient) { }

  apiKey= '08cc33bd5ae3a747598ce2ad84376e66';

  getAuth(): Observable<any> {
    return this.http.get('http://localhost:8020/VIDEO-SERVICE/api/movie/authentication');
  }

  bannerApiData(): Observable<any> {
    return this.http.get(environment.backendMovieHost+'/trending/all/week?api_key='+this.apiKey);
  }

  trendingMovieApiData(): Observable<any> {
    return this.http.get(environment.backendMovieHost+'/trending/movie/day?api_key='+this.apiKey);
  }

  searchMovie(keyword: string): Observable<any> {
    console.log('keyword:'+keyword);
     
    return this.http.get(environment.backendMovieHost+"/search/movie?api_key="+this.apiKey+"&query="+keyword);
  }

  getMovieDetails(movieId: string): Observable<any> {
    return this.http.get(environment.backendMovieHost+"/movie/"+movieId+"?api_key="+this.apiKey);
  }

  getMovideVideo(movieId: string): Observable<any> {
    return this.http.get(environment.backendMovieHost+"/movie/"+movieId+"/videos?api_key="+this.apiKey);
  }

  getMovieCast(movieId: string): Observable<any> {
    return this.http.get(environment.backendMovieHost+"/movie/"+movieId+"/credits?api_key="+this.apiKey);
  }

  fetchActionMovie(page: number= 1): Observable<any> {
    const params = new HttpParams().set('api_key', this.apiKey).set('with_genres', '28').set('page', page.toString());
    return this.http.get(environment.backendMovieHost+"/discover/movie", {params});
  }

  fetchAdventureMovie(): Observable<any> { 
    return this.http.get(environment.backendMovieHost+"/discover/movie?api_key="+this.apiKey+"&with_genres=12");
  }

  fetchAnimationMovie(): Observable<any> {
    return this.http.get(environment.backendMovieHost+"/discover/movie?api_key="+this.apiKey+"&with_genres=16"); 
  }

  fetchComedyMovie(): Observable<any> {
    return this.http.get(environment.backendMovieHost+"/discover/movie?api_key="+this.apiKey+"&with_genres=35"); 
  }

  fetchDocumentaryMovie(): Observable<any> {
    return this.http.get(environment.backendMovieHost+"/discover/movie?api_key="+this.apiKey+"&with_genres=99");    
  }

  fetchScienceFictionMovie(): Observable<any> {
    return this.http.get(environment.backendMovieHost+"/discover/movie?api_key="+this.apiKey+"&with_genres=878"); 
  }

  fetchThrillerMovie(): Observable<any> {
    return this.http.get(environment.backendMovieHost+"/discover/movie?api_key="+this.apiKey+"&with_genres=53");     
  }
  
}
