package com.example.backend.service;

import com.example.backend.dao.Product;
import com.example.backend.dao.ProductPrice;
import com.example.backend.dto.ProductCalculationRequest;
import com.example.backend.dto.ProductInfo;
import com.example.backend.dto.Response;
import com.example.backend.repository.ProductPriceRepository;
import com.example.backend.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductPriceRepository productPriceRepository;

    List<Long> commitments = Arrays.asList(3L, 6L);

    private static void commitmentCalculation(ProductCalculationRequest productCalculationRequest, List<ProductPrice> prices, ProductPrice initPrice, float initPriceValue, Response response) {
        float finalPrice;
        ProductPrice price = prices.stream()
                .filter(productPrice -> Objects.equals(productPrice.getPrice().getCommitmentMonths(), productCalculationRequest.getCommitment()))
                .findFirst().orElse(initPrice);
        finalPrice = price.getPrice().getValue() * price.getPrice().getCommitmentMonths() + initPriceValue;

        response.setMonths(price.getPrice().getCommitmentMonths());
        response.setTotalPrice(finalPrice);
        if (productCalculationRequest.getReturnMonths() != null) {
            long term = productCalculationRequest.getReturnMonths();
            float earlyPrice = term * initPriceValue + initPriceValue;
            response.setMessage("Early return in " + term + " months would cost: " + earlyPrice + " Eur");
        }
    }

    private static void noCommitmentCalculation(ProductCalculationRequest productCalculationRequest, float initPriceValue, Response response) {
        float finalPrice;
        if (productCalculationRequest.getReturnMonths() != null) {
            finalPrice = productCalculationRequest.getReturnMonths() * initPriceValue;
            response.setMonths(productCalculationRequest.getReturnMonths());
        } else {
            finalPrice = initPriceValue;
            response.setMonths(1L);
        }
        finalPrice += initPriceValue;
        response.setTotalPrice(finalPrice);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public ProductInfo getProductPrices(long id) {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProduct(productRepository.findById(id));
        productInfo.setPrices(productPriceRepository.findByProductId(id).stream()
                .map(ProductPrice::getPrice)
                .collect(Collectors.toList()));
        return productInfo;
    }

    public ResponseEntity<Response> calculatePrice(ProductCalculationRequest productCalculationRequest) {
        Response response = new Response();
        List<ProductPrice> prices = productPriceRepository.findByProductId(productCalculationRequest.getProductId());
        ProductPrice initPrice = prices.stream()
                .filter(x -> x.getPrice().getCommitmentMonths() == null)
                .findFirst().orElse(null);

        float initPriceValue = initPrice.getPrice().getValue();


        try {
            if (!commitments.contains(productCalculationRequest.getCommitment())) {
                noCommitmentCalculation(productCalculationRequest, initPriceValue, response);

            } else {
                commitmentCalculation(productCalculationRequest, prices, initPrice, initPriceValue, response);
            }
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().body(response);
        }
    }
}
