import axios from 'axios';

const API_URL = 'http://localhost:8080/api/auth/';

class AuthService{
    login(usuario){
        return axios
        .post(API_URL + 'login', {
            nombreUsuario: usuario.nombreUsuario,
            contrasena: usuario.contrasena
        })
        .then(response => {
            if(response.data.accessToken){
                localStorage.setItem('usuario', JSON.stringify(response.data));
            }
            return response.data;
        });
    }
    logout(){
        localStorage.removeItem('usuario');
    }

    register(usuario){
        return axios.post(API_URL + 'registro',
        {
             nombreUsuario: usuario.nombreUsuario
        })
    }

    
}

export default new AuthService();