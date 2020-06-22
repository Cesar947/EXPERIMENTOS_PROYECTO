

import axios from 'axios';
import { environment } from '../environment/environment';




class MembershipService {

    goldMembreship(id) {
        return axios
            .put(`${environment.api}/usuarios?membresia=GOLD&usuarioId=${id}`, null,{ headers: { Authorization: `Bearer ${localStorage.getItem("token")}` } })
    }
}


export default new MembershipService();