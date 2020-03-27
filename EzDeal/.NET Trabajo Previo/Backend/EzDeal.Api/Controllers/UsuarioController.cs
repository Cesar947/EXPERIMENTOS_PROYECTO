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
    public class UsuarioController : ControllerBase
    {

        private IUsuarioService usuarioService;

        public UsuarioController(IUsuarioService usuarioService)
        {
            this.usuarioService = usuarioService;
        }

        [HttpGet]
        public ActionResult Get()
        {
            return Ok(
                usuarioService.GetAll()
            );
        }
        [HttpGet("{id}")]
        public ActionResult GetById(int id)
        {
            return Ok(usuarioService.Get(id));
        }

        [HttpPost]
        public ActionResult Post([FromBody] Usuario usuario)
        {
            return Ok(
                usuarioService.Save(usuario)
            );
        }

        [HttpPut]
        public ActionResult Put([FromBody] Usuario usuario)
        {
            return Ok(
                usuarioService.Update(usuario)
            );
        }

        [HttpDelete("{id}")]
        public ActionResult Delete(int id)
        {
            return Ok(
                usuarioService.Delete(id)
            );
        }

    }
}