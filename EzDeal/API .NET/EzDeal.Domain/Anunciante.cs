using System;
using System.Collections.Generic;
namespace EzDeal.Domain
{
    public class Anunciante
    {
        public long Id { get; set; }
        public string TelefonoFijo { get; set; }
        public string Celular { get; set; }
        public string Dni { get; set; }
        public string urlContacto { get; set; }
        public string AntecedentesPenales { get; set; }
        public DateTime FechaCaducidad { get; set; }
        public Membresia Membresia { get; set; }

        //Para el One-To-one
        //Referencia: https://www.entityframeworktutorial.net/efcore/configure-one-to-one-relationship-using-fluent-api-in-ef-core.aspx
        public long UsuarioId { get; set; }
        public Usuario Usuario { get; set; }

        public ICollection<ComprobantePago> ComprobantesDePago {get; set;}


    }
}