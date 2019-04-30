package modelo;


public class PeliculaInventario {

     String i_inventory_id ; 
     String i_film_id;
     String f_title;
     String f_rental_duration;
     String f_length;
     String f_release_year;
     String i_store_id;
     String i_last_update;

    public PeliculaInventario(String i_inventory_id, String i_film_id, String f_title, String f_rental_duration, String f_length, String f_release_year, String i_store_id, String i_last_update) {
        this.i_inventory_id = i_inventory_id;
        this.i_film_id = i_film_id;
        this.f_title = f_title;
        this.f_rental_duration = f_rental_duration;
        this.f_length = f_length;
        this.f_release_year = f_release_year;
        this.i_store_id = i_store_id;
        this.i_last_update = i_last_update;
    }

     
     
    public String getI_inventory_id() {
        return i_inventory_id;
    }

    public void setI_inventory_id(String i_inventory_id) {
        this.i_inventory_id = i_inventory_id;
    }

    public String getI_film_id() {
        return i_film_id;
    }

    public void setI_film_id(String i_film_id) {
        this.i_film_id = i_film_id;
    }

    public String getF_title() {
        return f_title;
    }

    public void setF_title(String f_title) {
        this.f_title = f_title;
    }

    public String getF_rental_duration() {
        return f_rental_duration;
    }

    public void setF_rental_duration(String f_rental_duration) {
        this.f_rental_duration = f_rental_duration;
    }

    public String getF_length() {
        return f_length;
    }

    public void setF_length(String f_length) {
        this.f_length = f_length;
    }

    public String getF_release_year() {
        return f_release_year;
    }

    public void setF_release_year(String f_release_year) {
        this.f_release_year = f_release_year;
    }

    public String getI_store_id() {
        return i_store_id;
    }

    public void setI_store_id(String i_store_id) {
        this.i_store_id = i_store_id;
    }

    public String getI_last_update() {
        return i_last_update;
    }

    public void setI_last_update(String i_last_update) {
        this.i_last_update = i_last_update;
    }

   

    
}
