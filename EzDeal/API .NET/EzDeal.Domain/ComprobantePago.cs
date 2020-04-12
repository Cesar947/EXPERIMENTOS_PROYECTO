using System;
namespace EzDeal.Domain
{
    public class ComprobantePago
    {
        public long Id {get; set;}
        public double Importe {get; set;}
        public double Igv {get; set;}
        public double MontoTotal {get; set;}
        public DateTime FechaPago {get; set;}
        public DateTime HoraPago {get; set;}
        public string Producto {get; set;}

        public long AnuncianteId {get; set;}
        public Anunciante Anunciante {get; set;}

        

    }
}