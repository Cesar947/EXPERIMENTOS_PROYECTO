import Axios from "axios"
import { environment } from "../environment/environment"

class CitaService {


    async listarCitasCliente(id){
        return await Axios.get(
            `${environment.api}/citas/cliente/${id}`,
            {  headers:
                { Authorization: `Bearer ${localStorage.getItem("token")}` }}
        )
    }

    async listarCitasAnunciante(id){
        return await Axios.get(
            `${environment.api}/citas/anunciante/${id}`,
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

    async actualizarCostoFinal(costoFinal, id){
        return await Axios.put(`${environment.api}/citas/${id}/actualizacionCosto?costoFinal=${costoFinal}`, null, {
            headers:
                { Authorization: `Bearer ${localStorage.getItem("token")}` }
        })
    }
}

export default new CitaService()