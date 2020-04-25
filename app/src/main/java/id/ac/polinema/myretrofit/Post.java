package id.ac.polinema.myretrofit;

import com.google.gson.annotations.SerializedName;

public class Post {
    @SerializedName("id_siswa")
    private String id_siswa;

    @SerializedName("nama")
    private String nama;

    @SerializedName("alamat")
    private String alamat;

    @SerializedName("jenis_kelamin")
    private String jenis_kelamin;

    @SerializedName("no_telp")
    private String no_telp;

    public Post(String nama, String alamat, String jenis_kelamin, String no_telp) {
        this.nama = nama;
        this.alamat = alamat;
        this.jenis_kelamin = jenis_kelamin;
        this.no_telp = no_telp;
    }

    public Post(String id_siswa, String nama, String alamat, String jenis_kelamin, String no_telp) {
        this.id_siswa = id_siswa;
        this.nama = nama;
        this.alamat = alamat;
        this.jenis_kelamin = jenis_kelamin;
        this.no_telp = no_telp;
    }

    public String getId_siswa() {
        return id_siswa;
    }

    public void setId_siswa(String id_siswa) {
        this.id_siswa = id_siswa;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

//    private String nim;
//    private String nama;
//    private String alamat;
//    private String no_telp;
//
//    public String getNim() {
//        return nim;
//    }
//
//    public String getNama() {
//        return nama;
//    }
//
//    public String getAlamat() {
//        return alamat;
//    }
//
//    public String getNo_telp() {
//        return no_telp;
//    }
}
