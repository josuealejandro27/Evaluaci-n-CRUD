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
import mx.utng.jaep.model.entity.Estudio;
import mx.utng.jaep.model.service.IEstudioService;


@Controller
@SessionAttributes("estudio")
public class EstudioController {
    //Inyectamos una dependencia del servicio
    @Autowired
    private IEstudioService estudioService;

    //Manda llamar este metodo en una peticion GET que contenga como final de la query string "", "/", "/list"
    @GetMapping({"/estudio/list","/estudio","/estudio/"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Estudios");
    model.addAttribute("estudios", estudioService.list());
    return "eslist";
    }

    //Peticion que contenga al final de la url /form
    @GetMapping("/estudio/form")
    public String create (Model model){
        model.addAttribute("title", "Formulario de Estudios");
        model.addAttribute("estudio", new Estudio());
        return "esform";
    }

    @GetMapping("/estudio/form/{id}")
    public String update(@PathVariable Long id,Model model){
        Estudio estudio = null;
        if (id>0) {
            estudio = estudioService.getById(id);
        }else{
            return "redirect:slist";
        }

        model.addAttribute("title", "Editar Estudio");
        model.addAttribute("estudio", estudio);
        return "esform";
    }


    @PostMapping ("/estudio/form")
    public String save(@Valid Estudio estudio, BindingResult br, Model model){

        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de Estudios");
            return "esform";
        }

        estudioService.save(estudio);
        return "redirect:/estudio/list";
    }

    @GetMapping("/estudio/delete/{id}")
    public String delete (@PathVariable Long id, Model model){
        if (id>0) {
            estudioService.delete(id);
        }
        return "redirect:/estudio/list";
    }
}

