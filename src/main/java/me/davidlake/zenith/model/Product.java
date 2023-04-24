package me.davidlake.zenith.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.FilterDefs;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
@FilterDefs({
	@FilterDef(name = "minPriceFilter",
		parameters = {
			@ParamDef(name="minPriceParam", type=Double.class)
        }
	),
    @FilterDef(name = "maxPriceFilter",
    parameters = {
        @ParamDef(name="maxPriceParam", type=Double.class)
    }
),
	@FilterDef(name = "colorFilter",
		parameters = {
			@ParamDef(name="colorParam", type=String.class)
        }
	)
})
@Filters({
	@Filter(name = "minPriceFilter",
            condition = ":minPriceParam is null or price >= :minPriceParam"),
    @Filter(name = "maxPriceFilter",
        condition = ":maxPriceParam is null or price <= :maxPriceParam"),
    @Filter(name = "colorFilter",
            condition = "color = :colorParam")
})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "color")
    private String color;

    @Column(name = "price")
    private double price;
}