import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { MovieDetailsComponent } from './pages/movie-details/movie-details.component';
import { SearchComponent } from './pages/search/search.component';
import { LoginComponent } from './pages/login/login.component';
import { CardMovieComponent } from './pages/card-movie/card-movie.component';
import { SingupComponent } from './pages/singup/singup.component';
import { AuthGuard } from './guards/auth.guard';


const routes: Routes = [
  { path: '', component: HomeComponent }, 
  { path: 'movie/:id', component: MovieDetailsComponent},
  { path: 'search', component: SearchComponent },
  { path: 'login', component: LoginComponent, canActivate: [AuthGuard]},
  { path: 'cardMovie/:category', component: CardMovieComponent},
  { path: 'signup', component: SingupComponent},
  //{ path: 'dashboard', component: DashboardComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
