import Axios from "axios"
import { environment } from "../environment/environment"

class SolicitudService {

    solicitar(servicioId, clienteId, solicitud) {
        //Aquí también le quitaremos las llaves a solicitud?
        return Axios.post(`${environment.api}/solicitudes?clienteId=${clienteId}&servicioId=${servicioId}`, solicitud, {
            headers:
                { Authorization: `Bearer ${localStorage.getItem("token")}` }
        })
    }


    async getSolicitudesPorAnunciante(idAnunciante) {
        return await Axios.get(`${environment.api}/solicitudes/anunciante/${idAnunciante}`, { headers: { Authorization: `Bearer ${localStorage.getItem("token")}` } })
    }

    async getSolicitudesPorServicio(idServicio) {
        return await Axios.get(`${environment.api}/solicitudes/servicio/${idServicio}`, { headers: { Authorization: `Bearer ${localStorage.getItem("token")}` } })
    }

    async aceptarSolicitud(idSolicitud, horaFin) {
        return await Axios.put(`${environment.api}/solicitudes/${idSolicitud}?horaFin=${horaFin}&estado=Aceptada`, null, { headers: { Authorization: `Bearer ${localStorage.getItem("token")}` } })
    }

    async rechazarSolicitud(idSolicitud, motivo) {
        return await Axios.put(`${environment.api}/solicitudes/${idSolicitud}?estado=Rechazada`, motivo, { headers: { Authorization: `Bearer ${localStorage.getItem("token")}` } })
    }
}


export default new SolicitudService()