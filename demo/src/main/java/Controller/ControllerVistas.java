package Controller;

import Service.UsuarioController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping("/usuario")
public class ControllerVistas {
UsuarioController usuarioController = new UsuarioController();

    public ControllerVistas() throws SQLException {
    }

    @GetMapping("/")
    public String crud(Model model){
        String valorfinal="./usuario/vistalistar";
        try {
            model.addAttribute("entidades", usuarioController.obtenerUsuarios());
        } catch (SQLException ex) {
            Logger.getLogger(ControllerVistas.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
    }
    // Página para listar entidades
    @GetMapping("/")
    public String listarEntidades() {
        return "./usuario/vistalistar";
    }

    // Página para editar una entidad existente
    @GetMapping("/editar/{id}")
    public String editarEntidad(@PathVariable("id") Long id) {
        // Aquí iría la lógica para obtener la entidad con el ID dado y pasarla al modelo
        return "editar";
    }

    // Lógica para guardar los cambios de la entidad
    @PostMapping("/guardar")
    public String guardarEntidad(/* Parámetros del formulario */) {
        // Aquí iría la lógica para guardar los cambios en la entidad
        return "redirect:/"; // Redirige de vuelta a la página de listar
    }

    // Lógica para eliminar una entidad
    // Implementar método y ruta correspondiente si deseas tener funcionalidad de eliminación
}
