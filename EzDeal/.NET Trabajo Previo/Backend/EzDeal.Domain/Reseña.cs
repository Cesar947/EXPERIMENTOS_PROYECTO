namespace EzDeal.Domain
{
    public class Reseña
    {
        public int Id {get; set;}
        public string Contenido {get; set;}
        public float Valoracion {get; set;}
        public int? AnuncioId {get; set;}
        public int? ClienteId {get; set;}
        public virtual Anuncio Anuncio {get;set;}
        public virtual Usuario Cliente {get;set;}

        


    }
}