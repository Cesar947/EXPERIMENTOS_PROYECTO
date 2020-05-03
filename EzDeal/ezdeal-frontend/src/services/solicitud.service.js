import Axios from "axios"
import { environment } from "../environment/environment"

class SolicitudService{

    solicitar(servicioId,clienteId,solicitud){
        return Axios.post(`${environment}/solicitud?servicioId=${servicioId}&clienteId=${clienteId}`,{solicitud})
    }
}


export default new SolicitudService()