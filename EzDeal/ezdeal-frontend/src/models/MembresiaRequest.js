export default class MembresiaRequest {

    constructor(
        id,
        numeroTarjeta,
        ccv,
        fechaVencimiento) {

        this.id = id;
        this.numeroTarjeta = numeroTarjeta;
        this.ccv = ccv;
        this.fechaVencimiento = fechaVencimiento;

    }
}