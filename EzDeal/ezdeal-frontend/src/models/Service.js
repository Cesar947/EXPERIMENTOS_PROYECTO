export default class ServiceRequest {
    constructor(
        titulo,
        descripcion,
        costoServicio,
        modalidad

    ) {
        this.titulo = titulo
        this.descripcion = descripcion;
        this.imagen = "img.jpg";
        this.estaHabilitado = 1;
        this.costoServicio = (costoServicio);
        this.modalidad =  (modalidad);
        this.videoPresentacion = "videoPresentacion.mp4";

        this.horarios = [
            { dia: 'Lunes', horaApertura: '', horaCierre: '' }
        ]

    }
}


// modalidad -> 1 - 0 

