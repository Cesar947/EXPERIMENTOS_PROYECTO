using EzDeal.Domain;
using EzDeal.Repository;
using EzDeal.Repository.ViewModel;
using System.Collections.Generic;

namespace EzDeal.Service.Implementacion
{
    public class SolicitudService : ISolicitudService
    {

        private ISolicitudRepository solicitudRepository;
        public SolicitudService(ISolicitudRepository solicitudRepository)
        {
            this.solicitudRepository=solicitudRepository;
        }
        
        public bool Delete(int id)
        {
            return solicitudRepository.Delete(id);
        }

        public Solicitud Get(int id)
        {
            return solicitudRepository.Get(id);
        }

        public IEnumerable<Solicitud> GetAll()
        {
           return solicitudRepository.GetAll();
        }

        public IEnumerable<SolicitudViewModel> GetAllSolicitudes()
        {
            return solicitudRepository.GetAllSolicitudes();
        }

        public bool Save(Solicitud entity)
        {
            return solicitudRepository.Save(entity);
        }

        public bool Update(Solicitud entity)
        {
            return solicitudRepository.Update(entity);
        }
    }
}