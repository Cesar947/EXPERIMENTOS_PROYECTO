import Axios from "axios";
import { environment } from "../environment/environment";

class ServicePublication {


    submitService(anuncianteId, tipoServicioId, servicio) {
        return Axios.post(`${environment.api}/servicios?tipoServicioId=${tipoServicioId}&anuncianteId=${anuncianteId}`, {
            servicio
        })
    }

    async getServiceDetail(id) {


        console.log(environment.token);
        return await Axios.get(`${environment.api}/servicios/${id}`)
    }

    async publicarSolicitud(clienteId, servicioId, body) {
        return await Axios.post(`${environment.api}/solicitudes?clienteId=${clienteId}&servicioId=${servicioId}`, { body })
    }

}

export default new ServicePublication();