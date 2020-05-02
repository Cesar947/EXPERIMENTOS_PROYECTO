/*import axios from 'axios';
import authHeader from './auth-header';

const API_URL = 'http://localhost:8080/api/test/';

class UserService {
  getPublicContent() {
    return axios.get(API_URL + 'all');
  }

  getUserBoard() {
    return axios.get(API_URL + 'user', { headers: authHeader() });
  }

  getModeratorBoard() {
    return axios.get(API_URL + 'mod', { headers: authHeader() });
  }

  getAdminBoard() {
    return axios.get(API_URL + 'admin', { headers: authHeader() });
  }
}*/
import axios from 'axios';
import { environment } from '../environment/environment';

class UserService {

    registrarUsuario(signUpRequest) {
        return axios
            .post(`${environment.api}/auth/registro`, {signUpRequest})
    }
}


export default new UserService();