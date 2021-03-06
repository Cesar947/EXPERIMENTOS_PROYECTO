using System.Collections.Generic;
namespace EzDeal.Domain
{
    public class Servicio
    {
        public int Id { get; set; }
        public string Titulo { get; set; }
        public string Descripcion { get; set; }
        public int Valor_Servicio { get; set; }
        public bool Esta_Habilitado { get; set; }
        public float Valoracion { get; set; }

        public int AnuncianteId { get; set; }
        public Usuario Anunciante { get; set; }

        public int ServicioId { get; set; }
        public TipoServicio TipoServicio { get; set; }

        public ICollection<Solicitud> solicitudes {get; set;}

        public ICollection<Horario> Horarios {get; set;}
    }
}