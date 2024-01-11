import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CardMovieComponent } from './pages/card-movie/card-movie.component';

const routes: Routes = [
  /*{ path: '', component: HomeComponent }, 
  { path: 'search', component: SearchComponent, canActivate: [AuthGuard], data: { roles:[]} },
  { path: 'movie/:id', component: MovieDetailsComponent},
  { path: 'login', component: LoginComponent},
  { path: 'singup', component: SingupComponent},*/
  { path: 'cardMovie/:category', component: CardMovieComponent}
  //{ path: 'dashboard', component: DashboardComponent}*/
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
