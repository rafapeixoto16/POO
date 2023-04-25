import java.io.Serializable;
import java.util.Objects;

public class Utilizador implements Serializable {
    private static int numeroUtizadores = 0;
    public static void incTotalUsers(){numeroUtizadores++;}
    public static int numeroUser(){return numeroUtizadores;}
    private int codigo;
    private String email;
    private String nome;
    private String morada;
    private int numeroFiscal;
    private double dinheiroVendas;


    /**----------------------------------------------
                        Utilizador
     ----------------------------------------------**/
    public Utilizador(){
        incTotalUsers();
        this.codigo = numeroUtizadores;
        this.email = "";
        this.nome  = "";
        this.morada = "";
        this.numeroFiscal = 0;
        this.dinheiroVendas = 0.0;
    }
    public Utilizador(String email,String nome ,String morada,int numeroFiscal,double dinheiroVendas){
        incTotalUsers();
        this.codigo = numeroUtizadores;
        this.email = email;
        this.nome = nome;
        this.morada = morada;
        this.numeroFiscal = numeroFiscal;
        this.dinheiroVendas = dinheiroVendas;
    }

    public Utilizador (Utilizador utilizador){
        this.codigo = utilizador.codigo;
        this.email = utilizador.email;
        this.nome = utilizador.nome;
        this.morada = utilizador.morada;
        this.numeroFiscal = utilizador.numeroFiscal;
        this.dinheiroVendas = utilizador.dinheiroVendas;
    }


    /**----------------------------------------------
                         Getters
     ----------------------------------------------**/

    public int getCodigo() {
        return codigo;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getMorada() {
        return morada;
    }

    public int getNumeroFiscal() {
        return numeroFiscal;
    }

    public double getDinheiroVendas() {
        return dinheiroVendas;
    }

    /**----------------------------------------------
                        Setters
     ----------------------------------------------**/

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public void setNumeroFiscal(int numeroFiscal) {
        this.numeroFiscal = numeroFiscal;
    }

    public void setDinheiroVendas(double dinheiroVendas) {
        this.dinheiroVendas = dinheiroVendas;
    }


    /**----------------------------------------------
                          Clone
     ----------------------------------------------**/

    @Override
    public Utilizador clone(){
        return new Utilizador(this);
    }

    /**----------------------------------------------
                          Equals
     ----------------------------------------------**/

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;

        if ((obj == null) || (this.getClass() != obj.getClass())) return false;

        Utilizador utilizador = (Utilizador) obj;
        return (this.codigo == utilizador.codigo && this.nome.equals(utilizador.nome) && this.email.equals(utilizador.email) && this.numeroFiscal == utilizador.numeroFiscal);
    }

    /**----------------------------------------------
                          toString
     ----------------------------------------------**/

    @Override
    public String toString() {
        return "Informaçao do utilizador:" +
                "\n    Nome     -> " + nome +
                "\n    NIF      -> " + numeroFiscal +
                "\n    Email    -> " + email +
                "\n    Morada   -> " + morada +
                "\n    Cod.User -> " + codigo +
                "\n    Dinheiro Vendas : " + dinheiroVendas;
    }

    /**----------------------------------------------
                          hashCode
     ----------------------------------------------**/

    @Override
    public int hashCode() {
         return Objects.hash(nome,numeroFiscal,email,morada,codigo);
    }


}
