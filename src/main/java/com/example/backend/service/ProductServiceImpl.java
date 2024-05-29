package com.example.backend.service;

import com.example.backend.dao.Product;
import com.example.backend.dao.ProductPrice;
import com.example.backend.dto.ProductInfo;
import com.example.backend.dto.Request;
import com.example.backend.dto.Response;
import com.example.backend.repository.ProductPriceRepository;
import com.example.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductPriceRepository productPriceRepository;

    List<Long> commitments = Arrays.asList(3l, 6L);

    public List<Product> getProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    public ProductInfo getProductPrices(double id) {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProduct(productRepository.findById(id));
        productInfo.setPrices(productPriceRepository.findByProductId(id).stream().map(ProductPrice::getPrice).collect(Collectors.toList()));
        return productInfo;
    }

    public ResponseEntity<Response> calculatePrice(Request request) {
        List<ProductPrice> prices = productPriceRepository.findByProductId(request.getProductId());
        ProductPrice initPrice = prices.stream().filter(x -> x.getPrice().getCommitmentMonths() == null).findFirst().orElse(null);

        float initPriceValue = initPrice.getPrice().getValue();
        float finalPrice;

        Response response = new Response();

        try {
            if (!commitments.contains(request.getCommitment())) {
                //no commitment calculation
                if (request.getReturnMonths() != null) {
                    finalPrice = Long.parseLong(request.getReturnMonths()) * initPriceValue;
                    response.setMonths(Long.parseLong(request.getReturnMonths()));
                } else {
                    finalPrice = initPriceValue;
                    response.setMonths(1L);
                }
                finalPrice += initPriceValue;
                response.setTotalPrice(finalPrice);

            } else {
                ProductPrice price = prices.stream().filter(x -> x.getPrice().getCommitmentMonths() == request.getCommitment()).findFirst().orElse(initPrice);
                finalPrice = price.getPrice().getValue() * price.getPrice().getCommitmentMonths() + initPriceValue;
                response.setMonths(price.getPrice().getCommitmentMonths());
                response.setTotalPrice(finalPrice);
                if (request.getReturnMonths() != null) {
                    Long term = Long.parseLong(request.getReturnMonths());
                    float earlyPrice = term * initPriceValue + initPriceValue;
                    response.setMessage("Early return in " + term + " months would cost: " + earlyPrice + " Eur");
                }
            }
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().body(response);
        }
    }
}
