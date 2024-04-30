package Entity;
// La clase Usuario representa un usuario en el sistema.
 // Contiene los atributos básicos de un usuario, como su identificador,
 //nombre, edad y correo electrónico.

public class Usuario {
    private int id;
    private String nombre;
    private int edad;
    private String email;


     // Devuelve el identificador único del usuario.
     //@return El identificador único del usuario.

    public int getId() {
        return id;
    }


     //Establece el identificador único del usuario.
     //@param id El identificador único del usuario.

    public void setId(int id) {
        this.id = id;
    }


     //Devuelve el nombre del usuario.
     //@return El nombre del usuario.

    public String getNombre() {
        return nombre;
    }


     //Establece el nombre del usuario.
     //@param nombre El nombre del usuario.

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


     //Devuelve la edad del usuario.
     //@return La edad del usuario.

    public int getEdad() {
        return edad;
    }


     //Establece la edad del usuario.
     //@param edad La edad del usuario.

    public void setEdad(int edad) {
        this.edad = edad;
    }


     //Devuelve el correo electrónico del usuario.
     //@return El correo electrónico del usuario.

    public String getEmail() {
        return email;
    }


     //Establece el correo electrónico del usuario.
     //@param email El correo electrónico del usuario.

    public void setEmail(String email) {
        this.email = email;
    }
}

