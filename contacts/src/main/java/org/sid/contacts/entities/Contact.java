package org.sid.contacts.entities;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
public class Contact implements Serializable {

    @Id
    @GeneratedValue
    private Long id ;
    private String nom ;
    private String prenom ;

    @Temporal(TemporalType.DATE)
    private Date dateNaissance ;
    private String email ;
    private long tel;
    private String photo;

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public String getEmail() {
        return email;
    }

    public long getTel() {
        return tel;
    }

    public String getPhoto() {
        return photo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTel(long tel) {
        this.tel = tel;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Contact() {

    }

    public Contact( String nom, String prenom, Date dateNaissance, String email, long tel, String photo) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.email = email;
        this.tel = tel;
        this.photo = photo;
    }
}
