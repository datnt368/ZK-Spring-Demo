package vn.test.zkoss.viewmodels;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.ListModelList;
import vn.test.zkoss.models.Car;
import vn.test.zkoss.service.CarService;
import vn.test.zkoss.service.impl.CarServiceImpl;

import java.util.List;

@Slf4j
@Getter
@Setter
public class CarViewModel {

    private final CarService carService = new CarServiceImpl();
    private String keyword = "";
    private List<Car> carList = new ListModelList<>();
    private Car selectedCar;

    @Init
    public void init() {
        carList = new ListModelList<>(carService.getCars());
        if (carList.isEmpty()) {
            selectedCar = null;
        } else {
            selectedCar = carList.get(0);
        }
    }

    @Command
    @NotifyChange("carList")
    public void search() {
        log.info("Search car with keyword: {}", keyword);
        carList = carService.search(keyword);
    }

}
