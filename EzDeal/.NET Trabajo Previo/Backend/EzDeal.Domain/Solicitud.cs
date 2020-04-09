namespace EzDeal.Domain
{
    public class Solicitud
    {
        public int Id {get; set;}
        public string Mensaje {get; set;}
        public string Estado {get; set;}
        public string Aprobacion {get; set;}
        public int? AnuncioId {get; set;}
        public int? ClienteId {get; set;}
        public virtual Anuncio Anuncio { get;set;}
        public virtual Usuario Cliente {get;set;}
        
    }
}