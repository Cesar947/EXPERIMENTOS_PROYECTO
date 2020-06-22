import Axios from "axios"
import { environment } from "../environment/environment"

class CitaService {


    async listarCitasUsuario(id){
        return await Axios.get(
            `${environment.api}/citas/usuario/${id}`,
            {  headers:
                { Authorization: `Bearer ${localStorage.getItem("token")}` }}
        )
    }


    async actualizarEstadoCita(estado, id) {
        return await Axios.put(`${environment.api}/citas/${id}/actualizacionEstado?estado=${estado}`, null, {
            headers:
                { Authorization: `Bearer ${localStorage.getItem("token")}` }
        })
    }
}



export default new CitaService()