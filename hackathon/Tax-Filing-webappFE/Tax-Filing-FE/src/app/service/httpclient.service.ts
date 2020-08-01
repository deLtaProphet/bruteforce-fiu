import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

export class user {
  constructor(
    public username: string,
    public name: string,
    public occupation: string,
    public salary: string,
    public aaaccount: string,
    public fipsforsaving: string[],
  ) { }
}



@Injectable({
  providedIn: 'root'
})
export class HttpclientService {

  constructor(
    private httpClient: HttpClient
  ) {
  }


  getUserInfo(user) {
    return this.httpClient.get<user>("http://localhost:8080/users" + "/" + user.username);
  }


  addTaxSavingsCategory(selecetdTaxSchemes :string[]) {
    //return this.httpClient.post<number>("http://localhost:8080/users/getTaxschemes"+"/"+sessionStorage.getItem('username'),selecetdTaxSchemes);
    //return this.httpClient.get<String>('http://localhost:8080/users/validateLogin');
    //var schemes: selecetdTaxSchemes;
    var schems = {
      "schemes" : selecetdTaxSchemes
    }
    return this.httpClient.post<number>("http://localhost:8080/getTaxschemes/brutforce2@finvu",schems);
  }
  /* 

  public deleteEmployee(employee) {
    return this.httpClient.delete<Employee>("http://localhost:8080/employees" + "/" + employee.empId);
  }

  public createEmployee(employee) {
    return this.httpClient.post<Employee>("http://localhost:8080/employees", employee);
  }
   */
}