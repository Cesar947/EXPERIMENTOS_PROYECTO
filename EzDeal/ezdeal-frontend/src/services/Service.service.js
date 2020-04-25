import Axios from "axios";
import { environment } from "../environment/environment";

 class ServicePublication{


    submitService(anuncianteId,tipoServicioId, servicio){
        return Axios.post(`${environment}/auth/servicios?tipoServicioId=${tipoServicioId}&anuncianteId=${anuncianteId}`,{
            servicio
        })
    }

}

export default new ServicePublication();