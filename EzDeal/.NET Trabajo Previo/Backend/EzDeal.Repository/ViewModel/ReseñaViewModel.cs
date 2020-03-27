namespace EzDeal.Repository.ViewModel
{
    
    public class ReseñaViewModel
    {      
        public int Id {get; set;}
        public string Contenido {get; set;}
        public float Valoracion {get; set;}
        public int? AnuncioId {get; set;}
        public int? ClienteId {get; set;}
        public string AnuncioTitulo {get;set;}
        public string CLienteNombre {get;set;}
        
    }
}