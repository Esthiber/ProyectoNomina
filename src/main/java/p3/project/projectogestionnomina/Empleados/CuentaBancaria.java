package p3.project.projectogestionnomina.Empleados;

public class CuentaBancaria {
    private String TipoCuenta;
    private String NumeroCuenta;
    private String IDPropietario;
    private String Moneda;

    public String getMoneda() {
        return Moneda;
    }

    public void setMoneda(String moneda) {
        Moneda = moneda;
    }

    public CuentaBancaria() {
    }

    public CuentaBancaria(String tipoCuenta, String numeroCuenta, String moneda,String IDPropietario) {
        TipoCuenta = tipoCuenta.toUpperCase();
        NumeroCuenta = numeroCuenta;
        this.IDPropietario = IDPropietario;
        this.Moneda = moneda.toUpperCase();
    }

    public String AbreviarTipoCuenta(){
        String[] s = getTipoCuenta().replace("de","").split(" ");
        return s[0].toCharArray()[0] + "" + s[1].toCharArray()[0];
    }

    public String getTipoCuenta() {
        return TipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        TipoCuenta = tipoCuenta;
    }

    public String getNumeroCuenta() {
        return NumeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        NumeroCuenta = numeroCuenta;
    }

    public String getIDPropietario() {
        return IDPropietario;
    }

    public void setIDPropietario(String IDPropietario) {
        this.IDPropietario = IDPropietario;
    }
}
