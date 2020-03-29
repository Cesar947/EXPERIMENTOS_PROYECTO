namespace EzDeal.Repository.ViewModel
{
    
    public class SolicitudViewModel
    {
        public int Id {get; set;}
        public string Mensaje {get; set;}
        public string Estado {get; set;}
        public string Aprobacion {get; set;}
        public int? AnuncioId {get; set;}

        public string AnuncioTitulo {get;set;}
        public int? ClienteId {get; set;}
        public string ClienteNombre { get;set;}
        
    }
}