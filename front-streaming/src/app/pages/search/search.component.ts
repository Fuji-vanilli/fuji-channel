import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, RequiredValidator, Validators } from '@angular/forms';
import { MovieApiService } from 'src/app/services/movie-api.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit{

  formGroup!: FormGroup;
  movieSearchList: Array<any>= [];
  keyword: string= '';
  spinners: boolean= false;

  constructor(private formBuilder: FormBuilder,
              private movieService: MovieApiService) {}

  ngOnInit(): void {
    this.formGroup= this.formBuilder.group({
      keyword: this.formBuilder.control('', Validators.required)
    })

  }

  searchForm() {
    console.log(this.formGroup.value, 'serachvalue#');
    this.keyword= this.formGroup.value.keyword;
    this.spinners= true;
    this.movieService.searchMovie(this.keyword).subscribe(
      (data)=> {
        console.log(this.movieSearchList);
        setTimeout(() => {
          this.movieSearchList= data.results;
        }, 2000);

        setTimeout(() => {
          this.spinners= false;
        }, 2000);
      }
    )
    
  }

}
