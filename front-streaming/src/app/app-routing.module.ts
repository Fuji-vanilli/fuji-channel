import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { MovieDetailsComponent } from './pages/movie-details/movie-details.component';

const routes: Routes = [
  { path: '', component: HomeComponent }, 
  { path: 'movie/:id', component: MovieDetailsComponent},
  /*{ path: 'search', component: SearchComponent, canActivate: [AuthGuard], data: { roles:[]} },
 
  { path: 'login', component: LoginComponent},
  { path: 'singup', component: SingupComponent},
  { path: 'cardMovie/:category', component: CardMovieComponent},
  { path: 'dashboard', component: DashboardComponent}*/
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
