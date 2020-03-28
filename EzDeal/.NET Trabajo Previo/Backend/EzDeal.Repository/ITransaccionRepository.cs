using EzDeal.Domain;
using System.Collections.Generic;
using EzDeal.Repository.ViewModel;

namespace EzDeal.Repository
{
    public interface ITransaccionRepository : IRepository<Transaccion>
    {
        IEnumerable<TransaccionViewModel> GetAllTransacciones();
    }
}