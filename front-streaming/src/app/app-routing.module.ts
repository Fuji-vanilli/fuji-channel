import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CardMovieComponent } from './pages/card-movie/card-movie.component';
import { HomeComponent } from './pages/home/home.component';
import { SearchComponent } from './pages/search/search.component';
import { MovieDetailsComponent } from './pages/movie-details/movie-details.component';
import { LoginComponent } from './pages/login/login.component';
import { SingupComponent } from './pages/singup/singup.component';
import { AuthGuard } from './guards/auth.guard';
import { DashboardComponent } from './pages/dashboard/dashboard.component';

const routes: Routes = [
  { path: '', component: HomeComponent }, 
  { path: 'search', component: SearchComponent, canActivate: [AuthGuard], data: { roles:[]} },
  { path: 'movie/:id', component: MovieDetailsComponent},
  { path: 'login', component: LoginComponent},
  { path: 'singup', component: SingupComponent},
  { path: 'cardMovie/:category', component: CardMovieComponent},
  { path: 'dashboard', component: DashboardComponent, canActivate: [AuthGuard], data: { roles:[]} }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
