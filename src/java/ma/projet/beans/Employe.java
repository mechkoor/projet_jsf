/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

import java.util.Date;
import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
     @Column(name = "dateDeNaissance")
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    
    private boolean isChief;
    
    @ManyToOne
    private Service service;

    @ManyToOne
    private Employe chef;

    public Employe() {
        
        super();
    }

    public Employe(String nom,String prenom,Date dateNaissance,  Service service, Employe chef) {
        this.nom=nom;
        this.prenom = prenom;
        
  
        this.dateNaissance = dateNaissance;

        this.service = service;
        this.chef = chef;
        
         this.isChief = isChief;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

  

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }


    public Employe getChef() {
        return chef;
    }

    public void setChef(Employe chef) {
        this.chef = chef;
    }
    
    public boolean isChief() {
        return isChief;
    }

    public void setChief(boolean isChief) {
        this.isChief = isChief;
    }

}