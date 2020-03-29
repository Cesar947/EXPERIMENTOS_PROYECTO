using System;

namespace EzDeal.Domain
{
    public class Usuario
    {
        public int Id {get; set;}
        public char Rol {get; set;}
        public string Email {get; set;}
        public string Contraseña {get; set;}
        public string Nombres {get; set;}
        public string Apellidos {get; set;}
        public string Url_Contacto {get; set;}
        public string TelefonoFijo {get; set;}
        public string Celular {get;set;}
        public string Distrito {get; set;}
        public string Direccion {get; set;}
        public string Provincia {get; set;}

    }
}
