using System;
namespace EzDeal.Domain
{
    public class Horario
    {
        public long Id {get; set;}
        public string Dia {get; set;}
        public DateTime horaApertura {get; set;}
        public DateTime horaCierre {get; set;}
        
        public long ServicioId {get; set;}
        public Servicio Servicio {get; set;}
    }
}