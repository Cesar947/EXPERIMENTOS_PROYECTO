

import axios from 'axios';
import { environment } from '../environment/environment';




class MembershipService {

    goldMembreship(id) {
        return axios
            .put(`${environment.api}/auth/membresia/GOLD?anuncianteId=${id}`)
    }
}


export default new MembershipService();