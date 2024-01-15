import { Component, HostListener, OnInit } from '@angular/core';
import { Movie } from '../models/movie';
import { SecurityService } from '../services/security.service';
import { KeycloakService } from 'keycloak-angular';
import { KeycloakProfile } from 'keycloak-js';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {
  title: string= 'FUJI-CHANEL';
  navBg: any;
  public profile?: KeycloakProfile | null;

  genresMovie: Array<Movie>= [
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

  constructor(private kcService: KeycloakService) {}
  ngOnInit(): void {
    if (this.kcService.isLoggedIn()) {
      this.kcService.loadUserProfile().then(
        profile=> {
          this.profile= profile;
        }
      )
    }
  }
/*
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
*/
  async login() {
    await this.kcService.login({
      redirectUri: window.location.origin+"/dashboard"
    })
  }

  logout() {
    event?.preventDefault();
    this.kcService.logout(window.location.origin);
  }

  register() {
    this.kcService.register({
      redirectUri: window.location.origin
    })
  }

  toggleMenu() {
    const subMenu= document.getElementById("subMenu");
    if (subMenu) {
      subMenu.classList.toggle("open-menu");
    }
  }
}
