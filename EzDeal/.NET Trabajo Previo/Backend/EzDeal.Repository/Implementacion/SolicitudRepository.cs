using System;
using System.Collections.Generic;
using System.Linq;
using EzDeal.Domain;
using EzDeal.Repository.Context;
using EzDeal.Repository.ViewModel;
using Microsoft.EntityFrameworkCore;

namespace EzDeal.Repository.Implementacion
{
    public class SolicitudRepository : ISolicitudRepository
    {

        private ApplicationDbContext context;

        public SolicitudRepository(ApplicationDbContext context)
        {
            this.context = context;
        }
        public Solicitud Get(int id)
        {
            var result = new Solicitud();
            try
            {
                result = context.Solicitudes.Single(x => x.Id == id);
            }

            catch (System.Exception)
            {

                throw;
            }
            return result;
        }

        public IEnumerable<Solicitud> GetAll()
        {

            var result = new List<Solicitud>();
            try
            {
                result = context.Solicitudes.ToList();
            }

            catch (System.Exception)
            {

                throw;
            }
            return result;
        }
        public IEnumerable<SolicitudViewModel> GetAllSolicitudes()
        {
            var solicitud = context.Solicitudes
               .Include(o => o.Anuncio).Include(o => o.Cliente)
               .ToList();

            return solicitud.Select(o => new SolicitudViewModel
            {
                Id = o.Id,
                Mensaje = o.Mensaje,
                Estado = o.Estado,
                Aprobacion = o.Aprobacion,
                AnuncioId = o.AnuncioId,
                AnuncioTitulo = o.Anuncio.Titulo,
                ClienteId = o.ClienteId,
                ClienteNombre = o.Cliente.Nombre,
            });
        }

        public bool Save(Solicitud entity)
        {
            try
            {
                context.Add(entity);
                context.SaveChanges();
            }
            catch (System.Exception)
            {

                return false;
            }
            return true;
        }

        public bool Update(Solicitud entity)
        {
            try
            {
                var solicitudOrigina = context.Solicitudes.Single(
                    x => x.Id == entity.Id
                );

                solicitudOrigina.Id = entity.Id;
                solicitudOrigina.AnuncioId = entity.AnuncioId;
                solicitudOrigina.ClienteId = entity.ClienteId;
                solicitudOrigina.Mensaje = entity.Mensaje;
                solicitudOrigina.Estado = entity.Estado;
                solicitudOrigina.Aprobacion = entity.Aprobacion;

                context.Update(solicitudOrigina);
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
            var Solicitud = new Solicitud();
            try
            {
                
                context.Remove(context.Solicitudes.Single(x => x.Id == id));
                context.SaveChanges();
            }

            catch(System.Exception)
            {
                return false;
            }

            return true;
        }

    }
}