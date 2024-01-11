import { APP_INITIALIZER, NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavbarComponent } from './navbar/navbar.component';
import { HomeComponent } from './pages/home/home.component';
import { MovieDetailsComponent } from './pages/movie-details/movie-details.component';
import { SearchComponent } from './pages/search/search.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { PaginationModule } from 'ngx-bootstrap/pagination';
import { LoginComponent } from './pages/login/login.component';
import { CardMovieComponent } from './pages/card-movie/card-movie.component';
import { SingupComponent } from './pages/singup/singup.component';
import { KeycloakAngularModule, KeycloakService } from 'keycloak-angular';

export function initializeKeycloak(keycloak: KeycloakService) {
  return () =>
    keycloak.init({
      config: {
        url: 'http://localhost:8080',
        realm: 'streaming-ms',
        clientId: 'movie-client' 
      },
      initOptions: {
        onLoad: 'check-sso',
        silentCheckSsoRedirectUri:
          'http://localhost:4200/assets/silent-check-sso.html'
      }
    });
}


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    MovieDetailsComponent,
    SearchComponent,
    LoginComponent,
    CardMovieComponent,
    SingupComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule, 
    HttpClientModule,
    AppRoutingModule,
    KeycloakAngularModule,
    BrowserAnimationsModule,
    PaginationModule.forRoot(),  
  ],
  providers: [
    { 
      provide: APP_INITIALIZER, 
      deps: [KeycloakService], 
      useFactory: initializeKeycloak, 
      multi: true
  },
    provideClientHydration()
  ],
  bootstrap: [AppComponent]
})

export class AppModule { }
