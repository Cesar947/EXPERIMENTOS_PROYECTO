using EzDeal.Domain;
using EzDeal.Repository;
using EzDeal.Repository.ViewModel;
using System.Collections.Generic;

namespace EzDeal.Service.Implementacion
{
    public class AnuncioService : IAnuncioService
    {

        private IAnuncioRepository anuncioRepository;
        public AnuncioService(IAnuncioRepository anuncioRepository)
        {
            this.anuncioRepository=anuncioRepository;
        }
        
        public bool Delete(int id)
        {
            return anuncioRepository.Delete(id);
        }

        public Anuncio Get(int id)
        {
            return anuncioRepository.Get(id);
        }

        public IEnumerable<Anuncio> GetAll()
        {
           return anuncioRepository.GetAll();
        }

        public IEnumerable<AnuncioViewModel> GetAllAnuncios()
        {
            return anuncioRepository.GetAllAnuncios();
        }

        public bool Save(Anuncio entity)
        {
            return anuncioRepository.Save(entity);
        }

        public bool Update(Anuncio entity)
        {
            return anuncioRepository.Update(entity);
        }
    }
}