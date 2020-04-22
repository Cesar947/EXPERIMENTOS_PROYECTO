namespace EzDeal.Domain
{
    public class Reseña
    {
        public long Id {get; set;}
        public string Contenido {get; set;}
        public double Valoracion {get; set;}

        public long ServicioId {get; set;}
        public Servicio Servicio {get; set;}

        public long ClienteId {get; set;}
        public Usuario Cliente {get; set;}


    }
}