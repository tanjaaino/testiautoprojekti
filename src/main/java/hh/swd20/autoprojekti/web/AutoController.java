package hh.swd20.autoprojekti.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.autoprojekti.domain.Auto;

// huom. ei @ResponseBody-annotaatiota
@Controller
public class AutoController {
	
	// palauttaa autolistauksen
	@RequestMapping(value = "/cars", method = RequestMethod.GET)
	public String getAutot(Model model) {
		// ei haeta vielä tietokannasta autoja
		List<Auto> autot = new ArrayList<Auto>();// luodaan tyhjä lista
		autot.add(new Auto("Tesla", 2016));  // lisätään 1. auto
		autot.add(new Auto("Saab", 1986));  // lisätään 2.auto
		System.out.println(autot);
		// lisätään autolista model-olion mappiin avainarvolla templatea varten
		model.addAttribute("autot", autot); //1. "keyword" for map, 2. dataobject
		
		return "autolista"; // palautetaan autolista.html-templaten nimi DispatcherServletille
	}
	
}
