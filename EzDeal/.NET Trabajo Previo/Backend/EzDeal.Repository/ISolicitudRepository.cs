using EzDeal.Domain;
using System.Collections.Generic;
using EzDeal.Repository.ViewModel;

namespace EzDeal.Repository
{
    public interface ISolicitudRepository : IRepository<Solicitud>
    {
        IEnumerable<SolicitudViewModel> GetAllSolicitudes();
    }
}