import Axios from "axios";
import { environment } from "../environment/environment";

class ServicePublication {


    submitService(anuncianteId, tipoServicioId, servicio) {
        console.log(servicio);
        return Axios.post(`${environment.api}/servicios?tipoServicioId=${tipoServicioId}&anuncianteId=${anuncianteId}`, servicio, { headers: { Authorization: `Bearer ${localStorage.getItem("token")}` } })
    }

    async getServiceDetail(id) {


        console.log(environment.token);
        return await Axios.get(`${environment.api}/servicios/${id}`, { headers: { Authorization: `Bearer ${localStorage.getItem("token")}` } })
    }

    async publicarSolicitud(clienteId, servicioId, body) {
        return await Axios.post(`${environment.api}/solicitudes?clienteId=${clienteId}&servicioId=${servicioId}`, body)
    }

    async getMyServices(anuncianteId) {
        return await Axios.get(`${environment.api}/servicios/${anuncianteId}`)
    }

}

export default new ServicePublication();