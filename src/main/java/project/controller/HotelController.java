package project.controller;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.model.hotel.Hotel;
import project.model.hotel.Rate;
import project.service.HotelService;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


/**
 * Created by slava23 on 11/28/2016.
 */

@Controller
@Data
@RequiredArgsConstructor(staticName = "of", onConstructor = @__(@Autowired))
@NoArgsConstructor
public class HotelController {

    @NonNull
    private HotelService hotelService;

    @RequestMapping(value = "/createHotel", method = GET)
    public String createHotel(@RequestParam(name = "name") String name,
                              @RequestParam(name = "rate") String rate,
                              @RequestParam(name = "country") String country,
                              @RequestParam(name = "region") String region,
                              Model model){
        Hotel hotel = hotelService.createHotel(name, Rate.valueOf(rate), country, region);
        model.addAttribute("hotel", hotel);
        return "hotel/showHotel";
    }

    @RequestMapping(value = "/updateHotel", method = GET)
    @Transactional
    public String updateHotel(@RequestParam(name = "id") int id,
                              @RequestParam(name = "name", required = false) String name,
                              @RequestParam(name = "rate", required = false) String rate,
                              @RequestParam(name = "country", required = false) String country,
                              @RequestParam(name = "region", required = false) String region,
                              Model model){
        Hotel hotelById = hotelService.findHotelById(id);
        if (hotelById != null) {
            if (name != null && !name.isEmpty()) {
                hotelById.setName(name);
            }
            if (rate != null && !rate.isEmpty()) {
                Rate newRate = Rate.valueOf(rate);
                hotelById.setRate(newRate.getRate());
            }
            if (country != null && !country.isEmpty()) {
                hotelById.setCountry(country);
            }
            if (region != null && !region.isEmpty()) {
                hotelById.setRegion(region);
            }
            hotelService.saveHotel(hotelById);
        }
        model.addAttribute("hotel", hotelById);
        return "hotel/updateHotel";
    }

    @RequestMapping(value = "/getHotelById", method = GET)
    public String findHotelById(@RequestParam(name = "id") int id,
                                Model model){
        Hotel hotelById = hotelService.findHotelById(id);
        model.addAttribute("hotel", hotelById);
        return "hotel/showHotel";
    }

    @RequestMapping(value = "/getHotelByName", method = GET)
    public String findHotelById(@RequestParam(name = "name") String name,
                                Model model){
        Hotel hotelByName = hotelService.findHotelByName(name);
        model.addAttribute("hotel", hotelByName);
        return "hotel/showHotel";
    }

    @RequestMapping(value = "/getHotelsByCountry", method = GET)
    public String findHotelsByCountry(@RequestParam(name = "country") String country,
                                      Model model){
        List<Hotel> hotelsByCountry = hotelService.findHotelsByCountry(country);
        model.addAttribute("allHotels", hotelsByCountry);
        return "hotel/showAllHotels";
    }

    @RequestMapping(value = "/getHotelsByRegion", method = GET)
    public String findHotelsByRegion(@RequestParam(name = "region") String region,
                                      Model model){
        List<Hotel> hotelsByRegion = hotelService.findHotelsByRegion(region);
        model.addAttribute("allHotels", hotelsByRegion);
        return "hotel/showAllHotels";
    }

    @RequestMapping(value = "/hotel", method = GET)
    public String hotelMenu(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userLoggedIn = authentication.getName();
        model.addAttribute("userLoggedIn", userLoggedIn);
        return "hotel/hotel";
    }

    @RequestMapping(value = "/deleteHotel", method = GET)
    public String deleteHotel(@RequestParam(name = "id") int id,
                              Model model){
        Hotel hotel = hotelService.deleteHotel(id);
        model.addAttribute("hotel", hotel);
        return "hotel/deleteHotel";
    }
}
