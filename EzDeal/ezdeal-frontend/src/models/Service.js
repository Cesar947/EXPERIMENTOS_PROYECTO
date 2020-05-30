export default class ServiceRequest {
    constructor(
        titulo,
        descripcion,
        costoServicio,
        modalidad,

    ) {
        this.titulo = titulo;
        this.imagen = "imagen.jpg";
        this.costoServicio = (costoServicio);
        this.descripcion = descripcion;
        this.estaHabilitado = 1;
        this.valoracion = 0.0;
        this.modalidad =  (modalidad);
        this.videoPresentacion = "video.mp4";
        this.horarios = [];

}
}

// "titulo": "Pasear igüanas",
//     "imagen": "dsgfsadgds.jpg",
//     "costoServicio": 60,
//     "descripcion": "Te paseo al igüana",
//     "estaHabilitado": 1,
//     "valoracion": 0.0,
//     "modalidad": 1,
//     "videoPresentacion": "dsgasdgdsgds.mp4",
//     "horarios": [
//       {
//         "dia": "Lunes",
//         "horaApertura": "13:30:30.123456789",
//         "horaCierre": "21:45:30.123456789"
//       },
//       {
//         "dia": "Martes",
//         "horaApertura": "13:30:30.123456789",
//         "horaCierre": "21:45:30.123456789"
//       },
//       {
//         "dia": "Miercoles",
//         "horaApertura": "13:30:30.123456789",
//         "horaCierre": "21:45:30.123456789"
//       },
//       {
//         "dia": "Jueves",
//         "horaApertura": "13:30:30.123456789",
//         "horaCierre": "21:45:30.123456789"
//       },
//       {
//         "dia": "Viernes",
//         "horaApertura": "13:30:30.123456789",
//         "horaCierre": "21:45:30.123456789"
//       }
//     ]