import { Component, HostListener } from '@angular/core';
import { Movie } from '../models/movie';
import { Router } from '@angular/router';
//import { SecurityService } from '../services/security.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent {
  title: string= 'FUJI-CHANEL';
  navBg: any;
  isAuthenticate: boolean= false;

  genresMovie: Movie[]= [
    {category: 'Action', url: 'action'},
    {category: 'Adventure', url: 'adventure'},
    {category: 'Animation', url: 'animation'},
    {category: 'Comedy', url: 'comedy'},
    {category: 'Thriller', url: 'thriller'},
    {category: 'Documentary', url: 'documentary'},
    {category: 'Action', url: 'action'},
    {category: 'Science Fiction', url: 'scienceFiction'},
    {category: 'Drame', url: 'drame'}
 
  ]

  constructor(public router: Router ) {}

  @HostListener('document:scroll') scrollover() {
    console.log(document.body.scrollTop, 'scrolltop#');
    if (document.body.scrollTop> 0 || document.documentElement.scrollTop> 0) {
      this.navBg= {
        'background-image': 'linear-gradient(to bottom, #140537, #13063b, #11083e, #0f0942, #0c0a46)'
      }
    } else {
      this.navBg= {
        'background-color': '#000000'
      }
    }
  } 

  signup() {
    this.router.navigateByUrl('/signup');
  }
}
