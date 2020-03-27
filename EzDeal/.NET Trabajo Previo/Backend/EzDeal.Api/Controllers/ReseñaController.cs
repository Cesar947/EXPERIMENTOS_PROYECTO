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
    public class ReseñaController : ControllerBase
    {

        private IReseñaService reseñaService;

        public ReseñaController(IReseñaService reseñaService)
        {
            this.reseñaService = reseñaService;
        }

        [HttpGet]
        public ActionResult Get()
        {
            return Ok(
                reseñaService.GetAll()
            );
        }

        [HttpPost]
        public ActionResult Post([FromBody] Reseña reseña)
        {
            return Ok(
                reseñaService.Save(reseña)
            );
        }

        [HttpPut]
        public ActionResult Put([FromBody] Reseña reseña)
        {
            return Ok(
                reseñaService.Update(reseña)
            );
        }

        [HttpDelete("{id}")]
        public ActionResult Delete(int id)
        {
            return Ok(
                reseñaService.Delete(id)
            );
        }

    }
}