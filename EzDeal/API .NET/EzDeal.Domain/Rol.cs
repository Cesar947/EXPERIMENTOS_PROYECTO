using System.Collections.Generic;
namespace EzDeal.Domain
{
    public class Rol
    {
        public long Id { get; set; }
        public string Nombre { get; set; }

        //Para el Many-to-many
        //Referencia: https://www.entityframeworktutorial.net/efcore/configure-many-to-many-relationship-in-ef-core.aspx
        public ICollection<RolCuenta> RolCuentas { get; set; }
    }
}