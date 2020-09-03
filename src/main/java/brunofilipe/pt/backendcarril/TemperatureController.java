package brunofilipe.pt.backendcarril;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@RequestMapping("/api/temperature")
public class TemperatureController {

    @Autowired
    TemperatureRepository temperatureRepository;

    @GetMapping("/")
    public Iterable<Temperature> getAll() {
        return temperatureRepository.findAll();
    }

    @PostMapping("/")
    public Temperature add(@RequestBody Temperature temperature) {
        temperature.setCreateDate(new Date());
        return temperatureRepository.save(temperature);
    }

}
