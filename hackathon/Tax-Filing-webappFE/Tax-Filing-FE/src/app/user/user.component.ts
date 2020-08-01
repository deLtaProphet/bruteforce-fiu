import { Component, OnInit } from '@angular/core';
import { HttpclientService, user } from '../service/httpclient.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  user:user;
  constructor(private httpClientService:HttpclientService) { }

  ngOnInit() {
    this.httpClientService.getUserInfo(sessionStorage.getItem('username')).subscribe(
     response =>this.handleSuccessfulResponse(response),
    );
 }

handleSuccessfulResponse(response)
{
   this.user=response;
}

}
