package com.hyperbank.maps.city.specification;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.domain.Specification;

import com.hyperbank.maps.city.entity.City;
import com.hyperbank.maps.continent.entity.Continent;
import com.hyperbank.maps.country.entity.Country;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import io.github.paulmarcelinbejan.toolbox.web.request.FilterBy;
import io.github.paulmarcelinbejan.toolbox.web.request.OrderBy;
import io.github.paulmarcelinbejan.toolbox.web.request.PagedRequest;

public class CitySpecification implements Specification<City> {

	private static final long serialVersionUID = -4870590784389874220L;

	protected List<FilterBy> filter;

	protected List<OrderBy> order;
	
	public CitySpecification(List<FilterBy> filter, List<OrderBy> order) {
		this.filter = filter;
		this.order = order;
	}

	public CitySpecification(List<FilterBy> filter) {
		this(filter, Collections.emptyList());
	}

	public CitySpecification(PagedRequest request) {
		this(request.getFilter(), request.getOrder());
	}

	@Override
	public Predicate toPredicate(Root<City> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		Predicate predicate = criteriaBuilder.conjunction();

		Map<String, Path<String>> fieldPathMap = fieldPathMap(root);
		
        for (FilterBy filterBy : filter) {
			predicate = criteriaBuilder.and(predicate, buildPredicate(criteriaBuilder, filterBy, fieldPathMap));
        }
        
		applyOrder(root, query, criteriaBuilder, fieldPathMap);
		
		return predicate;
	}
	
	private static Predicate buildPredicate(CriteriaBuilder criteriaBuilder, FilterBy filterBy,
			Map<String, Path<String>> fieldPathMap) {
	    String filterValue = filterBy.getValue();

		Path<String> fieldPath = fieldPathMap.get(filterBy.getField());
		if (fieldPath == null) {
			throw new IllegalArgumentException("Invalid field!");
		}

		return switch (filterBy.getComparisonOperator()) {
		case IS_EQUAL_TO -> criteriaBuilder.equal(fieldPath, filterValue);
		case IS_NOT_EQUAL_TO -> criteriaBuilder.notEqual(fieldPath, filterValue);
		case IS_LESS_THAN -> criteriaBuilder.lessThan(fieldPath, filterValue);
		case IS_LESS_THAN_OR_EQUAL -> criteriaBuilder.lessThanOrEqualTo(fieldPath, filterValue);
		case IS_GREATER_THAN -> criteriaBuilder.greaterThan(fieldPath, filterValue);
		case IS_GREATER_THAN_OR_EQUAL -> criteriaBuilder.greaterThanOrEqualTo(fieldPath, filterValue);
		case IS_IN -> {
			Object[] values = filterValue.split(",");
			yield fieldPath.in(values);
		}
		case IS_NOT_IN -> {
			Object[] values = filterValue.split(",");
			yield criteriaBuilder.not(fieldPath.in(values));
		}
		case IS_BETWEEN -> {
			String[] rangeValues = filterValue.split(",");
			if (rangeValues.length != 2) {
				throw new IllegalArgumentException("Invalid range format for IS_BETWEEN operator");
			}
			yield criteriaBuilder.between(fieldPath, rangeValues[0], rangeValues[1]);
		}
		case IS_LIKE -> criteriaBuilder.like(fieldPath, "%" + filterValue + "%");
		case STARTS_WITH -> criteriaBuilder.like(fieldPath, filterValue + "%");
		case ENDS_WITH -> criteriaBuilder.like(fieldPath, "%" + filterValue);
		default -> throw new IllegalArgumentException("Unsupported operator: " + filterBy.getComparisonOperator());
		};
	}

	protected void applyOrder(Root<City> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder,
			Map<String, Path<String>> fieldPathMap) {
		if (order != null && !order.isEmpty()) {
			customOrder(query, criteriaBuilder, fieldPathMap);
		} else {
			defaultOrder(root, query, criteriaBuilder);
		}
	}

	private void customOrder(CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder,
			Map<String, Path<String>> fieldPathMap) {
		if (order.isEmpty()) {
			return;
		}

		for (OrderBy orderBy : order) {
			String fieldName = orderBy.getField();

			Path<String> fieldPath = fieldPathMap.get(fieldName);

			switch (orderBy.getOrder()) {
			case ASC:
				query.orderBy(criteriaBuilder.asc(fieldPath));
				break;
			case DESC:
				query.orderBy(criteriaBuilder.desc(fieldPath));
				break;
			default:
				throw new IllegalArgumentException("Unsupported order: " + orderBy.getOrder());
			}
		}

	}

	private static void defaultOrder(Root<City> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		query.orderBy(criteriaBuilder.asc(root.get("id")));
	}
	
	private static Map<String, Path<String>> fieldPathMap(Root<City> root) {
		Join<City, Country> country = root.join("country");
		Join<City, Continent> continent = country.join("continent");
		
		Map<String, Path<String>> fieldPathMap = new HashMap<>();
		fieldPathMap.put("cityName", root.get("cityName"));
		fieldPathMap.put("countryName", country.get("countryName"));
		fieldPathMap.put("continentName", continent.get("continentName"));
		return fieldPathMap;
	}

}
