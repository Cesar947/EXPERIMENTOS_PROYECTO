using EzDeal.Domain;
using System.Collections.Generic;
using EzDeal.Repository.ViewModel;

namespace EzDeal.Repository
{
    public interface IAnuncioRepository: IRepository<Anuncio>
    {
        IEnumerable<AnuncioViewModel> GetAllAnuncios ();
    }
}