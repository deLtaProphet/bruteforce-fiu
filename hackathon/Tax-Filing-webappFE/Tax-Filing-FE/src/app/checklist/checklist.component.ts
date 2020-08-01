import { Component, OnInit } from '@angular/core';
import { HttpclientService } from '../service/httpclient.service';
import { Router } from '@angular/router';
import { AuthenticationService } from '../service/authentication.service';

import {
  FormBuilder,
  FormGroup,
  FormArray,
  FormControl,
  ValidatorFn
} from '@angular/forms';

@Component({
  selector: 'app-checklist',
  templateUrl: './checklist.component.html',
  styleUrls: ['./checklist.component.css']
})

export class ChecklistComponent {

  Gsal = ''
  hra = ''
  AddIncome = ''
  form: FormGroup;
  loaded = false;
  ordersData = [
    { id: 'MF', name: 'Mutual Fund' },
    { id: 'FD', name: 'Tax Save FD' },
    { id: 'LI', name: 'Life Insurance' },
    { id: 'NPS', name: 'National Pension Scheme' },
    { id: 'PPF', name: 'Personal Provident Fund' },
    { id: 'EPF', name: 'Employee Provident Fund' }
  ];

  get ordersFormArray() {
    return this.form.controls.orders as FormArray;
  }

  constructor(private router: Router,public formBuilder: FormBuilder, private httpClientService: HttpclientService) {
    this.form = this.formBuilder.group({
      orders: new FormArray([], minSelectedCheckboxes(1))
    });

    function minSelectedCheckboxes(min = 1) {
      const validator: ValidatorFn = (formArray: FormArray) => {
        const totalSelected = formArray.controls
          // get a list of checkbox values (boolean)
          .map(control => control.value)
          // total up the number of checked checkboxes
          .reduce((prev, next) => next ? prev + next : prev, 0);
    
        // if the total is not greater than the minimum, return the error message
        return totalSelected >= min ? null : { required: true };
      };
    
      return validator;
    }

    this.addCheckboxes();
  }

  private addCheckboxes() {
    this.ordersData.forEach(() => this.ordersFormArray.push(new FormControl(false)));
  }

  submit() {

    //localStorage.setItem('clickCounter', this.Gsal);
    sessionStorage.setItem('Gsala',this.Gsal);
    sessionStorage.setItem('hra',this.hra);
    sessionStorage.setItem('AddIncome',this.AddIncome);
    this.loaded = true;
    const selectedOrderIds = this.form.value.orders
      .map((checked, i) => checked ? this.ordersData[i].id : null)
      .filter(v => v !== null);
    console.log(selectedOrderIds);
    this.httpClientService.addTaxSavingsCategory(selectedOrderIds).subscribe( data => {
      this.loaded = false;
      console.log("redirect to my-returns");
      this.router.navigate(['my-returns'])
      console.log(data);
      var x=JSON.parse(JSON.stringify(data));
      if (typeof x.MF!='undefined' && x.MF) {
        sessionStorage.setItem('MF',x.MF);
      }
      if (typeof x.FD!='undefined' && x.FD) {
        sessionStorage.setItem('FD',x.FD);
      }
      if (typeof x.LI!='undefined' && x.LI) {
        sessionStorage.setItem('LI',x.LI);
      }
      if (typeof x.NPS!='undefined' && x.NPS) {
        sessionStorage.setItem('NPS',x.NPS);
      }
      if (typeof x.PPF!='undefined' && x.PPF) {
        sessionStorage.setItem('PPF',x.PPF);
      }
      if (typeof x.EPF!='undefined' && x.EPF) {
        sessionStorage.setItem('EPF',x.EPF);
      }
      /*
{ id: 'MF', name: 'Mutual Fund' },
    { id: 'FD', name: 'Tax Save FD' },
    { id: 'LI', name: 'Life Insurance' },
    { id: 'NPS', name: 'National Pension Scheme' },
    { id: 'PPF', name: 'Personal Provident Fund' },
    { id: 'EPF', name: 'Employee Provident Fund' }
      */
      //sessionStorage.setItem('MF',data.MF);
      //alert("Tax savings list created successfully. Check your AA site to approve consent");
    });
      }

}
