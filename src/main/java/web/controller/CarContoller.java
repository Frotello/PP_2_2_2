package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import web.service.CarServiceImpl;

import java.util.List;

@Controller
public class CarContoller {
    private final CarService carService;

    @Autowired // Реализовал Бин через конструктор
    public CarContoller(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String getCars(@RequestParam(name = "count", required = false, defaultValue = "5") int count,
                          ModelMap model){
        model.addAttribute("list", carService.getCars(count));
        return "cars";
    }

}
