import { RouterModule, Routes } from "@angular/router";
import { CadastroUsuarioComponent } from "./cadastro-usuario/cadastro-usuario.component";
import { LoginComponent } from "./login/login.component";
import { WalletAppComponent } from "./wallet-app/wallet-app.component";
import { MovimentacaoOverlayComponent } from "./movimentacao-overlay/movimentacao-overlay.component";

export const routes: Routes = [
    {
        path: 'cadastrar-usuario',
        component: CadastroUsuarioComponent
    },
    {
        path: 'wallet',
        component: WalletAppComponent
    },
    {
        path: '**',
        component: LoginComponent
    }
];


export const AppRoutingModule = RouterModule.forRoot(routes);
