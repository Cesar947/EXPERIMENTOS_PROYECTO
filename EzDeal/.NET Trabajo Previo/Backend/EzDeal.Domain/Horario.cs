using System;

namespace EzDeal.Domain
{
    public class Horario
    {
        public int Id {get; set;}
        public string Dia {get; set;}
        public DateTime HoraApertura {get; set;}
        public DateTime HoraCierre {get; set;}
        public int? ServicioId {get; set;}
        public virtual Servicio Servicio {get; set;}

    


    }
}