using System.Collections.Generic;
using System.Linq;
using EzDeal.Domain;
using EzDeal.Repository.Context;
//using Microsoft.EntityFrameworkCore;

namespace EzDeal.Repository.Implementacion
{
   public class ReseñaRepository : IReseñaRepository
    {

        private ApplicationDbContext context;

        public ReseñaRepository(ApplicationDbContext context)
        {
            this.context = context;
        }
        public Reseña Get(int id)
        {
            var result = new Reseña();
            try
            {
                result = context.Reseñas.Single(x => x.Id == id);
            }

            catch (System.Exception)
            {

                throw;
            }
            return result;
        }

        public IEnumerable<Reseña> GetAll()
        {

            var result = new List<Reseña>();
            try
            {
                result = context.Reseñas.ToList();
            }

            catch (System.Exception)
            {

                throw;
            }
            return result;
        }

        public bool Save(Reseña entity)
        {
            try
            {
                context.Add(entity);
                context.SaveChanges();
            }
            catch (System.Exception)
            {

                return false;
            }
            return true;
        }

        public bool Update(Reseña entity)
        {
            try
            {
                 var reseñaOrigina = context.Reseñas.Single(
                     x => x.Id == entity.Id
                 );

                 reseñaOrigina.Id=entity.Id;
                 reseñaOrigina.Contenido = entity.Contenido;
                 reseñaOrigina.Valoracion = entity.Valoracion;
                 reseñaOrigina.AnuncioId = entity.AnuncioId;
                 reseñaOrigina.ClienteId = entity.ClienteId;
                 
                 context.Update(reseñaOrigina);
                 context.SaveChanges();
            }
            catch (System.Exception)
            {
                
                return false;
            }
            return true;
        }

        public bool Delete(int id)
        {
            throw new System.NotImplementedException();
        }

    }
}