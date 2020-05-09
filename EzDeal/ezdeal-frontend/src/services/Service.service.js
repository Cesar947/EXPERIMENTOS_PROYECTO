import Axios from "axios";
import { environment } from "../environment/environment";

class ServicePublication {


    submitService(anuncianteId, tipoServicioId, servicio) {
        return Axios.post(`${environment}/auth/servicios?tipoServicioId=${tipoServicioId}&anuncianteId=${anuncianteId}`, {
            servicio
        })
    }

    async getServiceDetail(id) {

        // const config = { 
        //     headers: { 'Authorization': 'Bearer ' + environment.token } }

        console.log(environment.token);
        return await Axios.get(`${environment.api}/servicios/${id}`)
    }

}

export default new ServicePublication();