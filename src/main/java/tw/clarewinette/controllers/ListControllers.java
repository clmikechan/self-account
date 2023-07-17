package tw.clarewinette.controllers;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import tw.clarewinette.models.apis.list.DetailsTypeRequest;
import tw.clarewinette.services.ListServices;

@RestController
@RequestMapping("/list")
@RequiredArgsConstructor
public class ListControllers {
	private final ListServices listServices;

	@PostMapping(value = "/add-frequently-shop")
	public void addFrequentlyShop(@RequestBody @NotNull String frequentlyShopName) {
		listServices.addFrequentlyShop(0, frequentlyShopName);
	}

	@PostMapping(value = "/add-transaction-type")
	public void addTransactionType(@RequestBody @NotNull String transactionTypeName) {
		listServices.addTransactionType(0, transactionTypeName);
	}

	@PostMapping(value = "/add-account-data")
	public void addAccountData(@RequestBody @NotNull String accountName) {
		listServices.addAccountData(0, accountName);
	}

	@PostMapping(value = "/add-details-type", produces = "application/json;charset=utf-8")
	public void addAccountData(@RequestBody @Valid DetailsTypeRequest detailsTypeRequest) {
		listServices.addDetailsType(0, detailsTypeRequest);
	}

}
