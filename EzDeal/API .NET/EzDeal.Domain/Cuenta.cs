
using System.Collections.Generic;

namespace EzDeal.Domain
{
    public class Cuenta
    {
        public long Id {get; set;}
        public string Email {get; set;}
        public string Contraseña {get; set;}
        public ICollection<Rol> Roles {get; set;}

        //Para el One-to-one
        //Referencia: https://www.entityframeworktutorial.net/efcore/configure-one-to-one-relationship-using-fluent-api-in-ef-core.aspx
        public long UsuarioId {get; set;}
        public Usuario Usuario {get; set;}

        //Para el Many-to-many
        //Referencia: https://www.entityframeworktutorial.net/efcore/configure-many-to-many-relationship-in-ef-core.aspx
         public ICollection<RolCuenta> RolCuentas {get; set;}

    }
}