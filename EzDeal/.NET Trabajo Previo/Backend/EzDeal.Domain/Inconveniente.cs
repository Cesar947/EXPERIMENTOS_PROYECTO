namespace EzDeal.Domain
{
    public class Inconveniente
    {
        public int Id {get; set;}
        public string Descripcion {get; set;}
        public int? AnuncianteId {get; set;}
        public int? ServicioId {get; set;}
        public Usuario Anunciante {get; set;}
        public Servicio Servicio {get; set;}
    }
}