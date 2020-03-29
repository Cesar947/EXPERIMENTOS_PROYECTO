namespace EzDeal.Domain
{
    public class Transaccion
    {
        public int Id {get; set;}
        public string Mensaje {get; set;}
        public string Estado {get; set;}
        public string Aprobacion {get; set;}
        public int? ServicioId {get; set;}
        public int? ClienteId {get; set;}
        public virtual Servicio Servicio { get;set;}
        public virtual Usuario Cliente {get;set;}
        
    }
}