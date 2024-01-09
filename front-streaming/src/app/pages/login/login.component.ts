import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  formLogin!: FormGroup;



  constructor(private formBuilder: FormBuilder,
    private router: Router) { }

  ngOnInit(): void {
    this.formLogin = this.formBuilder.group({
      email: this.formBuilder.control('', Validators.required),
      password: this.formBuilder.control('', Validators.required)
    })
  }

  onLogin() {

  }

}
