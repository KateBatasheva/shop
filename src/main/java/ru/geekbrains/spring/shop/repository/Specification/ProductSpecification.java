package ru.geekbrains.spring.shop.repository.Specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.MultiValueMap;
import ru.geekbrains.spring.shop.model.entities.Product;
import ru.geekbrains.spring.shop.services.DirectionSorting;

import javax.persistence.criteria.Predicate;

public class ProductSpecification {


    public static final String TITLE = "title";
    public static final String PRICE = "price";
    public static final String MIN_PRICE = "min_price";
    public static final String MAX_PRICE = "max_price";

    private static Specification<Product> priceGreaterOrEqualsThan(int minPrice) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get(PRICE), minPrice);
    }

    private static Specification<Product> priceLesserOrEqualsThan(int maxPrice) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get(PRICE), maxPrice);
    }

    private static Specification<Product> titleContains(String titlePart) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get(TITLE), String.format("%%%s%%", titlePart));
    }

//
//    private static Specification<Product> titleStartsWith(String titlePart) {
//        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get(TITLE), String.format("s%%", titlePart));
//    }
//
//    private static Specification<Product> titleEndsWith(String titlePart) {
//        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get(TITLE), String.format("%%s", titlePart));
//    }

    public static Specification<Product> build(MultiValueMap<String, String> params) {
        Specification<Product> spec = Specification.where(null);
        if (params.containsKey(MIN_PRICE) && !params.getFirst(MIN_PRICE).isBlank()) {
            spec = spec.and(ProductSpecification.priceGreaterOrEqualsThan(Integer.parseInt(params.getFirst(MIN_PRICE))));
        }
        if (params.containsKey(MAX_PRICE) && !params.getFirst(MAX_PRICE).isBlank()) {
            spec = spec.and(ProductSpecification.priceLesserOrEqualsThan(Integer.parseInt(params.getFirst(MAX_PRICE))));
        }
        if (params.containsKey(TITLE) && !params.getFirst(TITLE).isBlank()) {
            spec = spec.and(ProductSpecification.titleContains(params.getFirst(TITLE)));
        }
        return spec;
    }}
