import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-criar-conta',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './cadastro-usuario.component.html',
  styleUrls: ['./cadastro-usuario.component.css']
})
export class CadastroUsuarioComponent implements OnInit {
  criarContaForm = new FormGroup({
    username: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
    confirmPassword: new FormControl('', Validators.required),
    email: new FormControl('', Validators.required)
  });


  ngOnInit(): void {}

  onSubmit() {
    if (this.criarContaForm.valid) {
      console.log('Form Data: ', this.criarContaForm.value);
      // Lógica para salvar a conta
    } else {
      console.log('Form inválido');
    }
  }

  onCancel() {
    this.criarContaForm.reset();
  }
}
