namespace EzDeal.Domain
{
    public class Reseña
    {
        public int Id {get; set;}
        public string Contenido {get; set;}
        public float Valoracion {get; set;}
        public int? ServicioId {get; set;}
        public int? ClienteId {get; set;}
        public virtual Servicio Servicio {get;set;}
        public virtual Usuario Cliente {get;set;}

        


    }
}