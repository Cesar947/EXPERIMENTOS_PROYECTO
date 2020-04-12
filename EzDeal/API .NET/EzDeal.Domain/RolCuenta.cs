namespace EzDeal.Domain
{
    public class RolCuenta
    {
        public long CuentaId {get; set;}
        public Cuenta Cuenta {get; set;}

        public long RolId {get; set;}
        public Rol Rol {get; set;}
    }
}