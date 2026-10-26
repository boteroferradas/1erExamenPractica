package Models;

public class StockLibreria {
    private int id;
    private int idlibro;
    private double prezocosto;
    private double prezoventa;
    private  int desconto;

    public StockLibreria(int idlibro, double prezocosto, double prezoventa, int desconto) {
        this.idlibro = idlibro;
        this.prezocosto = prezocosto;
        this.prezoventa = prezoventa;
        this.desconto = desconto;
    }

    public StockLibreria(int id, int idlibro, double prezocosto, double prezoventa, int desconto) {
        this.id = id;
        this.idlibro = idlibro;
        this.prezocosto = prezocosto;
        this.prezoventa = prezoventa;
        this.desconto = desconto;
    }

    public int getId() {
        return id;
    }

    public int getIdlibro() {
        return idlibro;
    }

    public void setIdlibro(int idlibro) {
        this.idlibro = idlibro;
    }

    public double getPrezocosto() {
        return prezocosto;
    }

    public void setPrezocosto(double prezocosto) {
        this.prezocosto = prezocosto;
    }

    public double getPrezoventa() {
        return prezoventa;
    }

    public void setPrezoventa(double prezoventa) {
        this.prezoventa = prezoventa;
    }

    public int getDesconto() {
        return desconto;
    }

    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }
}

