package vn.test.zkoss.service;

import vn.test.zkoss.models.Car;

import java.util.List;

public interface CarService {

    List<Car> getCars();

    List<Car> search(String keyword);

}
