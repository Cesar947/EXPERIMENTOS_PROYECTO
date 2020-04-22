namespace EzDeal.Domain
{
    public class Membresia
    {
        public long Id {get; set;}
        public string Nombre {get; set;}
        public double Costo {get; set;}

        public long AnuncianteId {get; set;}
        public Anunciante Anunciante {get; set;}
    }
}