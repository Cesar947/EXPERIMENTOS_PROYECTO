using System;
namespace EzDeal.Domain
{
    public class Agenda
    {
        public long Id {get; set;}
        public string Dia {get; set;}
        public DateTime HoraInicio {get; set;}
        public DateTime HoraFin {get; set;}

        public long SolicitudId {get; set;}
        public Solicitud Solicitud {get; set;}
    }
}