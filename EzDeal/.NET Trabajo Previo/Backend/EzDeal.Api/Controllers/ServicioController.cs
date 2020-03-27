using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using EzDeal.Service;
using EzDeal.Domain;
using EzDeal.Repository.Context;

namespace EzDeal.Api.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ServicioController : ControllerBase
    {

        ApplicationDbContext context;

        public ServicioController(ApplicationDbContext context)
        {
            this.context = context;
        }
        
       // GET api/values
        [HttpGet]
        public ActionResult<IEnumerable<Servicio>> Get()
        {
            return context.Servicios.ToList();
        }
    }
}