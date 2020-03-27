using EzDeal.Domain;
using System.Collections.Generic;
using EzDeal.Repository.ViewModel;

namespace EzDeal.Service
{
    public interface ISolicitudService: IService<Solicitud>
    {
        IEnumerable<SolicitudViewModel> GetAllSolicitudes();
    }
}