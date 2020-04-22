namespace EzDeal.Domain
{
    public class Inconveniente
    {
        public long Id {get; set;}
        public string Descripcion {get; set;}
        
        public long SolicitudId {get; set;}
        public Solicitud Solicitud {get; set;}
    }
}