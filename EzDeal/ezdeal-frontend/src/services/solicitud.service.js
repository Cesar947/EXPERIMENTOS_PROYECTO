import Axios from "axios"
import { environment } from "../environment/environment"

class SolicitudService{

    solicitar(servicioId,clienteId,solicitud){
        //Aquí también le quitaremos las llaves a solicitud?
        return Axios.post(`${environment}/solicitud?servicioId=${servicioId}&clienteId=${clienteId}`,{solicitud})
    }
}


export default new SolicitudService()