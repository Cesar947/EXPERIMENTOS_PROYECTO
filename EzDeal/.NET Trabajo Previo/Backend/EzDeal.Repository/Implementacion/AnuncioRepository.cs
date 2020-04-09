using System;
using System.Collections.Generic;
using System.Linq;
using EzDeal.Domain;
using EzDeal.Repository.Context;
using EzDeal.Repository.ViewModel;
using Microsoft.EntityFrameworkCore;

namespace EzDeal.Repository.Implementacion
{
   public class AnuncioRepository : IAnuncioRepository
    {

        private ApplicationDbContext context;

        public AnuncioRepository(ApplicationDbContext context)
        {
            this.context = context;
        }
        public Anuncio Get(int id)
        {
            var result = new Anuncio();
            try
            {
                result = context.Anuncios.Single(x => x.Id == id);
            }

            catch (System.Exception)
            {

                throw;
            }
            return result;
        }

        public IEnumerable<Anuncio> GetAll()
        {

            var result = new List<Anuncio>();
            try
            {
                result = context.Anuncios.ToList();
            }

            catch (System.Exception)
            {

                throw;
            }
            return result;
        }

        public bool Save (Anuncio entity) {

            Anuncio anuncio = new Anuncio {
                Titulo = entity.Titulo,
                Descripcion = entity.Descripcion,
                Costo_Servicio = entity.Costo_Servicio,
                Esta_Habilitado = entity.Esta_Habilitado,
                Valoracion = entity.Valoracion,
                Dia = entity.Dia,
                HoraInicio = entity.HoraInicio,
                HoraFin = entity.HoraFin,
                AnuncianteId=entity.AnuncianteId,
                ServicioId= entity.ServicioId

            };
            try {
                context.Anuncios.Add (anuncio);
                context.SaveChanges ();
    
            } catch (Exception ex) {
                return false;
            }
            return true;
        }

        public bool Update(Anuncio entity)
        {
            try
            {
                 var anuncioOrigina = context.Anuncios.Single(
                     x => x.Id == entity.Id
                 );

                 anuncioOrigina.Id=entity.Id;
                 anuncioOrigina.AnuncianteId = entity.AnuncianteId;
                 anuncioOrigina.Titulo = entity.Titulo;
                 anuncioOrigina.Descripcion = entity.Descripcion;
                 anuncioOrigina.Costo_Servicio = entity.Costo_Servicio;
                 anuncioOrigina.ServicioId = entity.ServicioId;
                 anuncioOrigina.Esta_Habilitado = entity.Esta_Habilitado;
                 anuncioOrigina.Valoracion = entity.Valoracion;
                 anuncioOrigina.Dia = entity.Dia;
                 anuncioOrigina.HoraInicio = entity.HoraInicio;
                 anuncioOrigina.HoraFin = entity.HoraFin;

                 context.Update(anuncioOrigina);
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

        public IEnumerable<AnuncioViewModel> GetAllAnuncios()
        {
             var anuncio = context.Anuncios
                .Include (o => o.Servicio).Include(o=>o.Anunciante)
                .ToList();

            return anuncio.Select (o => new AnuncioViewModel {
                Id = o.Id,
                    Titulo = o.Titulo,
                    Descripcion = o.Descripcion,
                    Costo_Servicio = o.Costo_Servicio,
                    Esta_Habilitado = o.Esta_Habilitado,
                    Valoracion = o.Valoracion,
                    Dia = o.Dia,
                    HoraInicio = o.HoraInicio,
                    HoraFin = o.HoraFin,
                    AnuncianteId = o.AnuncianteId,
                    AnuncianteNombre = o.Anunciante.Nombre,
                    ServicioId= o.ServicioId,
                    ServicioNombre = o.Servicio.Nombre,
            });
        }
    }
}