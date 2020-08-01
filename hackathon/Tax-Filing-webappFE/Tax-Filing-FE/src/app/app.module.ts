import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from "./header/header.component";
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { UserComponent } from './user/user.component';
import { SignupComponent } from './signup/signup.component';
import { MyReturnsComponent } from './my-returns/my-returns.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BasicAuthHttpInterceptorServiceService } from './service/basic-auth-http-interceptor-service.service';
import { ChecklistComponent } from './checklist/checklist.component';
import { MyreturnsComponent } from './myreturns/myreturns.component';


@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    LoginComponent,
    LogoutComponent,
    UserComponent,
    SignupComponent,
    MyReturnsComponent,
    ChecklistComponent,
    MyreturnsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [{
    provide:HTTP_INTERCEPTORS, useClass:BasicAuthHttpInterceptorServiceService, multi:true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
