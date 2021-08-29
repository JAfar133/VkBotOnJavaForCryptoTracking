package core.modules;

public class Crypto {
    private final String CRYPTO_STRING_FORMAT = "%d.%s(%s), цена=%s$ Изм.(24ч)%s";
    private int id;
    private String name;
    private String tiket;
    private String price;
    private String changes;




    public Crypto(int id, String name, String tiket, String price, String changes) {
        this.id = id;
        this.name = name;
        this.tiket = tiket;
        this.price = price;
        this.changes = changes;
    }

    public Crypto() {
        id =0;name="";tiket="";price="";changes="";
    }

    @Override
    public String toString() {
        return String.format(CRYPTO_STRING_FORMAT,id,name,tiket,price,changes);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTiket() {
        return tiket;
    }
    public void setTiket(String tiket) {
        this.tiket = tiket;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getChanges() {
        return changes;
    }
    public void setChanges(String changes) {
        this.changes = changes;
    }
}
