package mx.utng.jaep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import jakarta.validation.Valid;
import mx.utng.jaep.model.entity.Empleado;
import mx.utng.jaep.model.service.IEmpleadoService;


@Controller
@SessionAttributes("empleado")
public class EmpleadoController {
    //Inyectamos una dependencia del servicio
    @Autowired
    private IEmpleadoService empleadoService;

    //Manda llamar este metodo en una peticion GET que contenga como final de la query string "", "/", "/list"
    @GetMapping({"/empleado/list","/empleado","/empleado/"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Empleados");
    model.addAttribute("empleados", empleadoService.list());
    return "elist";
    }

    //Peticion que contenga al final de la url /form
    @GetMapping("/empleado/form")
    public String create (Model model){
        model.addAttribute("title", "Formulario de Empleados");
        model.addAttribute("empleado", new Empleado());
        return "eform";
    }

    @GetMapping("/empleado/form/{id}")
    public String update(@PathVariable Long id,Model model){
        Empleado empleado = null;
        if (id>0) {
            empleado = empleadoService.getById(id);
        }else{
            return "redirect:slist";
        }

        model.addAttribute("title", "Editar Emlpeado");
        model.addAttribute("empleado", empleado);
        return "eform";
    }


    @PostMapping ("/empleado/form")
    public String save(@Valid Empleado empleado, BindingResult br, Model model){

        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de Empleados");
            return "eform";
        }

        empleadoService.save(empleado);
        return "redirect:/empleado/list";
    }

    @GetMapping("/empleado/delete/{id}")
    public String delete (@PathVariable Long id, Model model){
        if (id>0) {
            empleadoService.delete(id);
        }
        return "redirect:/empleado/list";
    }
}

