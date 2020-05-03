export default class ServicioDetalle {
    // id= 2
    // titulo= "Amaestramiento de perros"
    // anunciante= {
    //     id: 1,
    //     rol: "A",
    //     email: "cpizarrollanos@gmail.com",
    //     contrasena: "xdxdxd5000",
    //     nombres: "César Alejandro",
    //     apellidos: "Pizarro Llanos",
    //     telefonoFijo: "7662341",
    //     telefonoCelular: "987654321",
    //     urlContacto: "www.facebook.com/c",
    //     distrito: "Magdalena del Mar",
    //     direccion: "Av. Cacao 305",
    //     provincia: "Lima"
    // }

    // tipoServicio= {
    //     id: 1,
    //     nombre: "Actividades para mascotas",
    //     descripcion: "Desde paseos hasta enseñarle trucos a sus mascotas"
    // }

    // imagen= "ajcnAidwifdnc.jpg"
    // valorServicio= 60.0
    // descripcion= "Si estas cansado de la desobediencia del Firulais, llámame"
    // estaHabilitado= "Habilitado"
    // valoracion= 0.0
    // fechaPublicacion= "2020-03-27"
    // constructor(id){
    //     this.id = id
    // }
    id = 1
    titulo = "Pasear perros"
    anunciante = {
        id: 2,
        nombres: "Juanelv",
        apellidoPaterno: "Salgado",
        apellidoMaterno: "Sánchez",
        departamento: "Lima",
        distrito: "Callao",
        direccion: "Av. Callao 555",
        provincia: "Lima",
        strikes: 0,
        cuentaHabilitada: true,
        imagenPerfil: "sadfasegfadsg.jpg",
        cuentaId: {
            id: 2,
            email: "slayr@gmail.com",
            nombreUsuario: "slayz08"
        },
        infoAnunciante: {
            id: 1,
            telefonoFijo: "7833432",
            celular: "997362512",
            dni: "74532261",
            urlContacto: "www.facebook.com/J",
            antecedentesPenales: "dsagsdgvdadfadw.pdf",
            fechaCaducidad: "2020-05-13",
            membresia: {
                id: 1,
                nombre: "GOLD",
                costo: "18.99"
            }
        }
    }
    tipoServicio = {
        id: 1,
        nombre: "Actividades para mascotas",
        descripcion: "Desde pasear perros hasta amaestramiento de tortugas"
    }
    imagen = "dsgfsadgds.jpg"
    costoServicio = 60.00
    descripcion = "Te paseo al perro"
    estaHabilitado = true
    valoracion = 0.0
    fechaPublicacion = "2020-04-30"
    modalidad = 1
    videoPresentacion = "dsgasdgdsgds.mp4"
    horarios =[
        {
            id: 1,
            dia: "Lunes",
            horaApertura: "13:30:30",
            horaCierre: "21:45:30"
        },
        {
            id: 2,
            dia: "Martes",
            horaApertura: "13:30:30",
            horaCierre: "21:45:30"
        },
    ]

}

