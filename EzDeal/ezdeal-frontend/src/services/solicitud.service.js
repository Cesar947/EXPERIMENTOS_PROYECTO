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
}


export default new SolicitudService()