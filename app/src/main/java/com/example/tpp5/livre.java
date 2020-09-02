package com.example.tpp5;

public class livre {
 public String  name ;
    public String  titre ;

    public String  mot_cle ;
    public String  resume ;


public livre() {}


public livre( String  name , String  titre , String  mot_cle , String  resume)
{
this.name=name ;
this.titre=titre   ;
this.mot_cle=mot_cle ;
this.resume=resume ;

}

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getTitre() {
        return titre;
    }

    public void setMot_cle(String mot_cle) {
        this.mot_cle = mot_cle;
    }

    public String getMot_cle() {
        return mot_cle;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getResume() {
        return resume;
    }



}
