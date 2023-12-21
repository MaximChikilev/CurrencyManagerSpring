package ua.kiev.prog.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
public class MyController {
    @Autowired
    private StatisticLoader statisticLoader;
    @Autowired
    private CurrencyUnitRepository currencyUnitRepository;
    @Autowired
    DateConverter dateConverter;

    static final Map<String, String> accounts = new ConcurrentHashMap<>();

    static {
        accounts.put("user1", "password1");
        accounts.put("user2", "password2");
    }

    @GetMapping("/")
    public String onIndex() {
        return "index2";
    }

    @PostMapping("/choice")
    public String onLogin(Model model,
                          @RequestParam String choice,
                          @RequestParam String startDate,
                          @RequestParam String finishDate,
                          @RequestParam String targetDate) {
        List<CurrencyUnit> list = statisticLoader.getCurrencyStatistic(
                dateConverter.prepareStringDate(startDate),
                dateConverter.prepareStringDate(finishDate),
                "usd");
        currencyUnitRepository.deleteAll();
        currencyUnitRepository.saveAll(list);
        switch (choice) {
            case "1":
                model.addAttribute("rez", currencyUnitRepository.getAverageRate());
                model.addAttribute("message", "Average currency");
                break;
            case "3":
                model.addAttribute("rez", currencyUnitRepository.getMaxRate());
                model.addAttribute("message", "Max currency");
                break;
            case "2":

                model.addAttribute("rez",currencyUnitRepository.findByDate(dateConverter.convertStringToDate(targetDate)).getRate());
                model.addAttribute("message", "Currency from date");
                break;
        }
        model.addAttribute("startDate",dateConverter.prepareStringDate(startDate));
        model.addAttribute("finishDate",dateConverter.prepareStringDate(finishDate));
        model.addAttribute("targetDate",dateConverter.prepareStringDate(targetDate));
        return "result2";
    }
}
