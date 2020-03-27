using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using EzDeal.Service;
using EzDeal.Domain;

namespace EzDeal.Api.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class SolicitudController : ControllerBase
    {

        private ISolicitudService solicitudService;

        public SolicitudController(ISolicitudService solicitudService)
        {
            this.solicitudService = solicitudService;
        }

        [HttpGet]
        public ActionResult Get()
        {
            return Ok(
                solicitudService.GetAllSolicitudes()
            );
        }

        [HttpPost]
        public ActionResult Post([FromBody] Solicitud solicitud)
        {
            return Ok(
                solicitudService.Save(solicitud)
            );
        }

        [HttpPut]
        public ActionResult Put([FromBody] Solicitud solicitud)
        {
            return Ok(
                solicitudService.Update(solicitud)
            );
        }

        [HttpDelete("{id}")]
        public ActionResult Delete(int id)
        {
            return Ok(
                solicitudService.Delete(id)
            );
        }

    }
}