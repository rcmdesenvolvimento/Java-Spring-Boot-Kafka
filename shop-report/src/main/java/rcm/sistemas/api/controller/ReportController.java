package rcm.sistemas.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import rcm.sistemas.api.dto.ShopReportDTO;
import rcm.sistemas.api.repository.ShopReportRepository;

@RestController
@RequestMapping("/shop_report")
@RequiredArgsConstructor
public class ReportController {

	private final ShopReportRepository shopReportRepository;

	@GetMapping
	public List<ShopReportDTO> getShopReport() {
		return shopReportRepository.findAll()
				.stream().map(shop -> ShopReportDTO.convert(shop))
				.collect(Collectors.toList());
	}

}
