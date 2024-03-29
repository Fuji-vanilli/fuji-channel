import { APP_INITIALIZER, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { KeycloakAngularModule, KeycloakService } from 'keycloak-angular';
import { ReactiveFormsModule } from '@angular/forms';
import { NavbarComponent } from './navbar/navbar.component';
import { CardMovieComponent } from './pages/card-movie/card-movie.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { MovieDetailsComponent } from './pages/movie-details/movie-details.component';
import { SearchComponent } from './pages/search/search.component';
import { SingupComponent } from './pages/singup/singup.component';
import { HttpClientModule } from '@angular/common/http';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { LoaderComponent } from './loader/loader.component';

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
          window.location.origin + '/assets/silent-check-sso.html'
      }
    });
}


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    CardMovieComponent,
    HomeComponent,
    LoginComponent,
    MovieDetailsComponent,
    SearchComponent,
    SingupComponent,
    DashboardComponent,
    LoaderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    KeycloakAngularModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [
    {
      provide: APP_INITIALIZER,
      deps: [KeycloakService],
      useFactory: initializeKeycloak,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
