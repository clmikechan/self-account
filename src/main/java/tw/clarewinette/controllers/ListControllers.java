package tw.clarewinette.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import tw.clarewinette.repositories.AccountDataRepository;
import tw.clarewinette.repositories.DetailsTypeRepository;
import tw.clarewinette.repositories.FrequentlyShopRepository;
import tw.clarewinette.repositories.TransactionTypeRepository;
import tw.clarewinette.services.ListServices;

@RestController
@RequestMapping("/list")
@RequiredArgsConstructor
public class ListControllers {
	private final ListServices listServices;

	@PostMapping(value = "/add-frequently-shop")
	public void addFrequentlyShop(@RequestBody String frequentlyShopName) {
		System.out.println("add-frequently-shop");
		listServices.addFrequentlyShop(0, frequentlyShopName);
	}
}
