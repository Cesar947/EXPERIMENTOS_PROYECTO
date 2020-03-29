using EzDeal.Domain;
using System.Collections.Generic;
using EzDeal.Repository.ViewModel;

namespace EzDeal.Repository
{
    public interface IServicioRepository: IRepository<Servicio>
    {
        IEnumerable<ServicioViewModel> GetAllAnuncios ();
    }
}