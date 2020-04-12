using System.Collections.Generic;
namespace EzDeal.Domain
{
    public class TipoServicio
    {
        public int Id {get; set;}
        public string Nombre {get;set;}
        public string descripcion {get; set;}
        public ICollection<Servicio> Servicios {get; set;}

    }
}