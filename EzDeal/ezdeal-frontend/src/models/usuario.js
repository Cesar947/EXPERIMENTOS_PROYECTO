export default class Usuario {
    constructor(
        nombreUsuario, email, contrasena,
        nombres,apellidoPaterno, apellidoMaterno,
        departamento, distrito, direccion,
        provincia) {
      this.nombreUsuario = nombreUsuario;
      this.email = email;
      this.contrasena = contrasena;
      this.nombres = nombres;
      this.apellidoPaterno = apellidoPaterno;
      this.apellidoMaterno = apellidoMaterno;
      this.departamento = departamento;
      this.distrito = distrito;
      this.direccion = direccion;
      this.provincia = provincia;
    }
  }