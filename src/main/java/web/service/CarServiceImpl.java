package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class CarServiceImpl implements CarService{
    private List<Car> carsList = new ArrayList<>();

    {
        carsList.add(new Car("Mercedes-Benz", "C-Class", "Black"));
        carsList.add(new Car("Audi", "C-Class", "White"));
        carsList.add(new Car("Mazda", "C-Class", "Green"));
        carsList.add(new Car("Toyota", "C-Class", "Red"));
        carsList.add(new Car("Mitsubishi", "C-Class", "Pink"));

    }

    public List<Car> getCars(int count) {
        if (count >= 5) {
            return carsList;
        }
        return carsList.stream().limit(count).collect(Collectors.toList());
    }
}
