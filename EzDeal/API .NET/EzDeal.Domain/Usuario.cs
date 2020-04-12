using System.Collections.Generic;

namespace EzDeal.Domain
{
    public class Usuario
    {
        public long Id {get; set;}
        public char Rol {get; set;}
        public string Email {get; set;}
        public string Contraseña {get; set;}
        public string Nombres {get; set;}
        public string ApellidoPaterno {get; set;}
        public string ApellidoMaterno {get; set;}
        public string Distrito {get; set;}
        public string Direccion {get; set;}
        public string Provincia {get; set;}
        public string Departamento {get; set;}
        public int Strikes {get; set;}
        public string CuentaHabilitada {get; set;}
        public string imagenPerfil {get; set;}
        public Cuenta Cuenta {get; set;}
        public Anunciante InfoAnunciante {get; set;}

        public ICollection<Servicio> Servicios {get; set;}
        public ICollection<Solicitud> Solicitudes {get; set;}




    }
}
