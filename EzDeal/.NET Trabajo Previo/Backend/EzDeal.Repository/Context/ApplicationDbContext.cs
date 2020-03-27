using EzDeal.Domain;
using Microsoft.EntityFrameworkCore;

namespace EzDeal.Repository.Context
{
    public class ApplicationDbContext : DbContext
    {

        public DbSet<Anuncio> Anuncios {get; set;}
        public DbSet<Reseña> Reseñas {get; set;}
      
        public DbSet<Servicio> Servicios {get;set;}
        
        public DbSet<Solicitud> Solicitudes{get; set;}
        
        public DbSet<Usuario> Usuarios {get; set;}
        //public DbSet<HorarioAtencion> HorarioAtencion {get; set;}

        public ApplicationDbContext(DbContextOptions<ApplicationDbContext> options) 
        : base(options)
        {
            
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Anuncio>()
                    .Property(p => p.Titulo)
                    .HasColumnName("titulo")
                    .HasMaxLength(50)
                    .IsRequired();

            /* modelBuilder.Entity<Anuncio>().HasOne(p=>p.Servicio).WithMany().HasForeignKey(p=>p.Servicio_Id);
            modelBuilder.Entity<Anuncio>().HasOne(p=>p.Anunciante).WithMany().HasForeignKey(p=>p.Anunciante_Id);

            modelBuilder.Entity<Solicitud>().HasOne(p=>p.Anuncio).WithMany().HasForeignKey(p=>p.Anuncio_Id);
            modelBuilder.Entity<Solicitud>().HasOne(p=>p.Cliente).WithMany().HasForeignKey(p=>p.Cliente_Id);

            modelBuilder.Entity<Reseña>().HasOne(p=>p.Anuncio).WithMany().HasForeignKey(p=>p.Anuncio_Id);
            modelBuilder.Entity<Reseña>().HasOne(p=>p.Cliente).WithMany().HasForeignKey(p=>p.Cliente_Id);

            modelBuilder.Entity<Anuncio>().HasOne(p=>p.Anunciante).WithMany().HasForeignKey(p=>p.Anunciante_Id);
            modelBuilder.Entity<Anuncio>().HasOne(p=>p.Servicio).WithMany().HasForeignKey(p=>p.Servicio_Id);*/









             /* modelBuilder.Entity<Anuncio>()
               .HasOne(p => p.servicio)
                .WithMany(b => b.Anuncios)
                .HasForeignKey(p => p.servicio_id);   */
                    
        }
    }
}