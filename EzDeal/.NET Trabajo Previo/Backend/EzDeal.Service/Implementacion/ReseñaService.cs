using EzDeal.Domain;
using EzDeal.Repository;
using System.Collections.Generic;

namespace EzDeal.Service.Implementacion
{
    public class ReseñaService : IReseñaService
    {

        private IReseñaRepository reseñaRepository;
        public ReseñaService(IReseñaRepository reseñaRepository)
        {
            this.reseñaRepository=reseñaRepository;
        }
        
        public bool Delete(int id)
        {
            return reseñaRepository.Delete(id);
        }

        public Reseña Get(int id)
        {
            return reseñaRepository.Get(id);
        }

        public IEnumerable<Reseña> GetAll()
        {
           return reseñaRepository.GetAll();
        }

        public bool Save(Reseña entity)
        {
            return reseñaRepository.Save(entity);
        }

        public bool Update(Reseña entity)
        {
            return reseñaRepository.Update(entity);
        }
    }
}