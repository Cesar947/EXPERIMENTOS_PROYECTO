using System;
using System.Collections.Generic;
namespace EzDeal.Domain
{
    public class Solicitud
    {
        public long Id {get; set;}

        public long ServicioId {get; set;}
        public Servicio Servicio {get; set;}

        public long ClienteId {get; set;}
        public Usuario Cliente {get; set;}

        public string Mensaje {get; set;}
        public string Estado {get; set;}
        public double CostoFinal {get; set;}
        public DateTime FechaSolicitud {get; set;}
        public DateTime HoraPactada {get; set;}
        public DateTime FechaPactada {get; set;}

        public ICollection<Agenda> CitasAgendadas {get; set;}
 
    
    }
}