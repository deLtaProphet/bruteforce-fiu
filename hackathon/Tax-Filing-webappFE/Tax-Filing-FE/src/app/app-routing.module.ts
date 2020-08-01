import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGaurdService } from './service/auth-guard.service';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { UserComponent } from './user/user.component';
import { SignupComponent } from './signup/signup.component';
import { MyReturnsComponent } from './my-returns/my-returns.component';
import { ChecklistComponent } from './checklist/checklist.component';


const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'myReturns', component: MyReturnsComponent,canActivate:[AuthGaurdService]},
  { path: 'login', component: LoginComponent },
  { path: 'logout', component: LogoutComponent,canActivate:[AuthGaurdService] },
  { path: 'signup', component: SignupComponent,canActivate:[AuthGaurdService] },
  { path: 'selectReturns', component: ChecklistComponent,canActivate:[AuthGaurdService] },
  { path: 'my-returns', component: MyReturnsComponent,canActivate:[AuthGaurdService]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
