using EzDeal.Domain;
using System.Collections.Generic;
using EzDeal.Repository.ViewModel;

namespace EzDeal.Service
{
    public interface IAnuncioService : IService<Anuncio>
    {
        IEnumerable<AnuncioViewModel> GetAllAnuncios();
    }
}