using EzDeal.Domain;
using Microsoft.EntityFrameworkCore;

namespace EzDeal.Repository.Context
{
    public class ApplicationDbContext: DbContext
    {
        public DbSet<Usuario> Usuarios {get; set;} 
        public ApplicationDbContext(DbContextOptions<ApplicationDbContext> options)
        : base(options){

        }
    }
}