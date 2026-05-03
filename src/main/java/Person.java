public abstract class  Person {
    private String id;
    private String nama;
    private String telepon;

    public Person() {}

    public Person(String id, String nama, String telepon) {
        this.id = id;
        this.nama = nama;
        this.telepon = telepon;
    }

    public String getId() {
        return id;
    }

    public boolean setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            System.out.println("ID tidak boleh kosong");
            return false;
        }
        this.id = id;
        return true;
    }

    public String getNama() {
        return nama;
    }

    public boolean setNama(String nama) {
        if (nama == null || nama.trim().isEmpty()) {
            System.out.println("Nama tidak boleh kosong");
            return false;
        }
        this.nama = nama;
        return true;
    }

    public String getTelepon() {
        return telepon;
    }

    public boolean setTelepon(String telepon) {
        this.telepon = telepon;
        return true;
    }
}
