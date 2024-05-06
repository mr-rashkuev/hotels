package com.example.hotelbook.room;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class RoomSpecification {

   public static Specification<RoomEntity> byHotel(String hotelName){
       return ((root, query, criteriaBuilder) ->
               criteriaBuilder.like(root.get("hotelName"),"%"+ hotelName+"%"));
   }

   public static Specification<RoomEntity> priceLessThan(double price){
       return (root, query, criteriaBuilder) ->
               criteriaBuilder.lessThan(root.get("price"), price);
   }

   public static Specification<RoomEntity> inThatCity(String city){
       return (root, query, criteriaBuilder) ->
               criteriaBuilder.equal(root.get("city"), city);
   }
}
