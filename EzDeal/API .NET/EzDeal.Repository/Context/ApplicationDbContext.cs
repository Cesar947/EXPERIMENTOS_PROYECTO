using EzDeal.Domain;
using Microsoft.EntityFrameworkCore;

namespace EzDeal.Repository.Context
{
    public class ApplicationDbContext: DbContext
    {
        public DbSet<Usuario> Usuarios {get; set;} 
        public DbSet<Cuenta> Cuentas {get; set;}
        public DbSet<RolCuenta> RolCuentas {get; set;}
        public DbSet<Rol> Roles {get; set;}
        public DbSet<Servicio> Servicios {get; set;}
        public DbSet<Horario> Horarios {get; set;}
        public DbSet<TipoServicio> TipoServicios {get; set;}
        public DbSet<Anunciante> Anunciantes {get; set;}
        public DbSet<Membresia> Membresias {get; set;}
        public DbSet<ComprobantePago> ComprobantesDePago {get; set;}
        public DbSet<Solicitud> Solicitudes {get; set;}
        public DbSet<Agenda> Agendas {get; set;}
        public DbSet<Reseña> Reseñas {get; set;}
        public DbSet<Inconveniente> Inconvenientes {get; set;}
        public ApplicationDbContext(DbContextOptions<ApplicationDbContext> options)
        : base(options){

        }
    }
}